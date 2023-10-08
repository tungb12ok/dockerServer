<%-- 
    Document   : GGAnalytics
    Created on : Jun 25, 2023, 11:09:17 PM
    Author     : msi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Matomo -->
<script>
    var _paq = window._paq = window._paq || [];
    /* tracker methods like "setCustomDimension" should be called before "trackPageView" */
    _paq.push(["setDocumentTitle", document.domain + "/" + document.title]);
    _paq.push(["setCookieDomain", "*.localhost"]);
    _paq.push(["setDomains", ["*.localhost/SWP391/home"]]);
    _paq.push(['trackPageView']);
    _paq.push(['enableLinkTracking']);
    (function () {
        var u = "https://swp391.matomo.cloud/";
        _paq.push(['setTrackerUrl', u + 'matomo.php']);
        _paq.push(['setSiteId', '3']);
        var d = document, g = d.createElement('script'), s = d.getElementsByTagName('script')[0];
        g.async = true;
        g.src = '//cdn.matomo.cloud/swp391.matomo.cloud/matomo.js';
        s.parentNode.insertBefore(g, s);
    })();
</script>
<noscript><p><img src="https://swp391.matomo.cloud/matomo.php?idsite=3&amp;rec=1" style="border:0;" alt="" /></p></noscript>
<!-- End Matomo Code -->
<!-- End Matomo Code -->

