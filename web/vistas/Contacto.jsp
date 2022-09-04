

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../style/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="../js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link rel="shortcut icon" href="../img/utiles/favicon.JPG"/>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <title>contact</title>
    </head>

    <script>
        $(document).ready(function () {
            $('.menuContainer').load('../menuopciones_1.jsp');
        });
    </script>
    <body>

        <div class="menuContainer"></div>

        <div class="main mt-5 mb-5">
            <div class="container w-100">
                <div class="row">
                    <div class=" col-lg-5  col-sm-12  col-md-6   pb-5 pe-5">
                        <img src="../img/utiles/contact-img.jpg" alt=""/>
                    </div>
                    <div class="col-lg-6  col-sm-12 col-md-6 pt-5 ms-4">
                        <div class="mb-4">
                            <h3>Envianos un correo</h3>
                        </div>
                        <form id="form" class="form" action="https://formspree.io/f/xgednddg" method="POST" >
                            <!-- Name input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form4Example1">Asunto</label>
                                <input type="text" id="form4Example1" class="form-control" name="name" required="true"/> 
                            </div>

                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form4Example2">Dirección Email</label>
                                <input type="email" id="form4Example2" class="form-control" name="email" required="true"/> 
                            </div>

                            <!-- Message input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form4Example3">Mensaje</label>
                                <textarea class="form-control" id="form4Example3" rows="4" name="message"></textarea>
                            </div>

                            <!-- Submit button -->
                            <button type="submit" class="btn btn-primary btn-block mb-4">Enviar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            const formm = document.querySelector("#form");
            formm.addEventListener('submit', handleSubmit);

            async function handleSubmit(event) {
                event.preventDefault();
                const form = new FormData(this);
                const response = await fetch(this.action,{
                        method: this.method,
                        body:form,
                        headers:{'Accept':'aplication/json'}
                });
                if(response.ok){
                    this.reset();
                    swal('Mensaje','Correo enviado con exito!',"success");
                }else{
                    swal('Mensaje','Correo enviado con exito!',"error");
                }
            }
        </script>





        <script>
            $(document).ready(function () {
                $('.footerContainer').load('../componentes/footer_1.jsp');
            });
        </script>
        <div class="footerContainer"></div>



    </body>
</html>
