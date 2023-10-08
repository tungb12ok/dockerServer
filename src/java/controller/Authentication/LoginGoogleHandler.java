
import DAO.CustomerDAO;
import DAO.MentorDAO;
import DAO.UserDao;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import controller.Authentication.CodeRandom;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;
import entity.Customer;
import entity.Mentor;

/**
 * @author heaty566
 */
@WebServlet(urlPatterns = {"/LoginGoogleHandler"})
public class LoginGoogleHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CodeRandom a = new CodeRandom();
        String code = request.getParameter("code");
        String accessToken = getToken(code);
        UserGoogleDto user = getUserInfo(accessToken);
        UserDao dao = new UserDao();
        CustomerDAO customerDAO = new CustomerDAO();
        MentorDAO mentorDAO = new MentorDAO();
        HttpSession session = request.getSession();
        String nameRandom = "User-" + a.randomCode();
        if (dao.searchAccountByMail(user.getEmail()) == null) {
            dao.registerUser(user.getEmail(), "", nameRandom, user.getEmail(), "", 3, 0, 1); // Verified = 0 -> User need to update profile to user 
            customerDAO.registerCustomer(dao.searchAccountByMail(user.getEmail()).getId());
            Customer curUser = customerDAO.getCustomerWhenLogin(user.getEmail());
            session.setAttribute("account", curUser);
            request.getRequestDispatcher("home").forward(request, response);
        } else {
            if (dao.searchAccountByMail(user.getEmail()).getStatus() == 1 && dao.searchAccountByMail(user.getEmail()).getRoleID() == 3) {
                Customer curUser = customerDAO.getCustomerWhenLogin(user.getEmail());
                session.setAttribute("account", curUser);
                request.getRequestDispatcher("home").forward(request, response);
            } else if (dao.searchAccountByMail(user.getEmail()).getStatus() == 1 && dao.searchAccountByMail(user.getEmail()).getRoleID() == 2) {
                Mentor mentor = mentorDAO.getMentorWhenLogin(user.getEmail());
                session.setAttribute("account", mentor);
                request.getRequestDispatcher("mentor").forward(request, response);
            } else {
                request.setAttribute("mess", "Account was blocked by ADMIN !!!");
                request.getRequestDispatcher("signin.jsp").forward(request, response);
            }

        }

    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static UserGoogleDto getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();

        UserGoogleDto googlePojo = new Gson().fromJson(response, UserGoogleDto.class);

        return googlePojo;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
