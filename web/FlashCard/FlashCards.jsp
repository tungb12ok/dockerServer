<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>FCourse</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="../assets/img/favicon.png" rel="icon">
        <link href="../assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet">
        <!-- Vendor CSS Files -->
        <link href="../../assets/vendor/animate.css/animate.min.css" rel="stylesheet">
        <link href="../../assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="../../assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="../../assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="../../assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="../../assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="../../assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <link href="../../assets/css/style.css" rel="stylesheet">
        <%@include file="/component/GGAnalytics.jsp" %>
        <style>


            .flashcard-fl {
                display: flex;
                flex-direction: column;
                align-items: center;

            }

            .flashcard {
                position: relative;
                width: 800px;
                height: 450px;
                background-color: #fff;
                padding: 20px;
                margin-bottom: 20px;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                cursor: pointer;
                perspective: 1000px;
                transition: transform 0.5s, opacity 0.5s;
            }

            .question,
            .answer {
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                transition: transform 0.5s;
                backface-visibility: hidden;
                display: flex;
                align-items: center;
                justify-content: center;
                text-align: center;
                color: #333;
            }

            .question {
                transform: rotateY(0deg);
                background-color: #F0F8FF;
            }

            .answer {
                transform: rotateY(180deg);
                background-color: #FFF8DC;
            }

            .flashcard.flipped .question {
                transform: rotateY(180deg);
            }

            .flashcard.flipped .answer {
                transform: rotateY(0deg);
            }

            .hidden {
                display: none;
            }

            .controls {
                display: flex;
                justify-content: center;
                margin-top: 20px;
            }

            .controls button {
                margin: 0 10px;
                padding: 10px 20px;
                font-size: 16px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            .controls button:hover {
                background-color: #45a049;
            }
            .flashcard.hidden {
                opacity: 0;
                transform: scale(0.8);
            }
        </style>
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var flashcards = document.getElementsByClassName('flashcard');
                var currentIndex = 0;
                var autoPlayInterval;
                var isAutoPlaying = false; // Track auto-play state

                function showFlashcard(index) {
                    if (index >= 0 && index < flashcards.length) {
                        for (var i = 0; i < flashcards.length; i++) {
                            flashcards[i].classList.add('hidden');
                        }
                        flashcards[index].classList.remove('hidden');
                        flashcards[index].style.opacity = 1;
                        currentIndex = index;
                    }
                }

                function showNextFlashcard() {
                    var nextIndex = currentIndex + 1;
                    if (nextIndex >= flashcards.length) {
                        nextIndex = 0;
                    }
                    showFlashcard(nextIndex);
                }

                function showPreviousFlashcard() {
                    var prevIndex = currentIndex - 1;
                    if (prevIndex < 0) {
                        prevIndex = flashcards.length - 1;
                    }
                    showFlashcard(prevIndex);
                }

                function autoPlay() {
                    showNextFlashcard();
                }

                for (var i = 0; i < flashcards.length; i++) {
                    flashcards[i].addEventListener('click', function () {
                        this.classList.toggle("flipped");
                    });
                }

                nextBtn.addEventListener('click', showNextFlashcard);
                prevBtn.addEventListener('click', showPreviousFlashcard);
                playBtn.addEventListener('click', function () {
                    if (isAutoPlaying) {
                        clearInterval(autoPlayInterval); // Stop auto-play
                        isAutoPlaying = false;
                        playBtn.textContent = 'Play';
                    } else {
                        autoPlayInterval = setInterval(autoPlay, 2000); // Start auto-play
                        isAutoPlaying = true;
                        playBtn.textContent = 'Pause';
                    }
                });

                showFlashcard(currentIndex);
            });

        </script>
    </head>

    <body>
        <%@include file="../component/navbar.jsp" %>
        <main id="main">

            <h1 class="container h2" style="padding-top: 100px;">Flashcards: ${fl.getTitle()}</h1>



            <hr class="container">
            <div class="flashcard-fl">
                <c:forEach var="i" items="${listFlashcards}" varStatus="status">
                    <div class="flashcard ${status.index > 0 ? 'hidden' : ''}">
                        <div class="question">
                            <h2 style="white-space: pre-line">${i.getQuestion()}</h2>
                        </div>
                        <div class="answer">
                            <p>${i.getAnswer()}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div style="justify-content: center;">
                <div class="controls">
                    <button id="prevBtn">Prev</button>
                    <button id="playBtn">Play</button>
                    <button id="nextBtn">Next</button>
                </div>
            </div>
            <hr class="container">
            <h5 class="container ">Created by: ${uDAO.searchAccountByID(fl.getAuthor()).getFull_name()}</h5>
            <h5 class="container text-success">All Terminology:</h5>
            <div class="container">
                <table>
                    <thead>
                        <tr>
                            <th>Question</th>
                            <th>Answer</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="a" items="${listFlashcards}">
                            <tr>
                                <td><pre style="white-space: pre-line">${a.getQuestion()}</pre></td>
                                <td><pre style="white-space: pre-line">${a.getAnswer()}</pre></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <style>
                        td {
                            word-wrap: break-word;
                            overflow-wrap: break-word;
                        }
                    </style>

                </table>
                <style>
                    .fl {
                        width: 100%;
                        overflow-x: auto;
                    }

                    table {
                        width: 100%;
                        border-collapse: collapse;
                    }

                    th, td {
                        padding: 8px;
                        border: 1px solid #ccc;
                    }

                    th {
                        background-color: #f1f1f1;
                    }

                    tr:nth-child(even) {
                        background-color: #f9f9f9;
                    }

                    tr:hover {
                        background-color: #e9e9e9;
                    }
                </style>


            </div>
        </main>
        <%@include file="../component/footer.jsp" %>
        <!-- Vendor JS Files -->
        <script src="../../assets/vendor/purecounter/purecounter_vanilla.js"></script>
        <script src="../../assets/vendor/aos/aos.js"></script>
        <script src="../../assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="../../assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="../../assets/vendor/php-email-form/validate.js"></script>
        <!-- Template Main JS File -->
        <script src="../../assets/js/main.js"></script>
    </body>

</html>
