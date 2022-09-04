var btnAbrirPopup = document.getElementById('btn-abrir-popup'),
    overlay = document.getElementById('overlay'),
    popup = document.getElementById('popup'),
    btnCerrarPopup = document.getElementById('btn-cerrar-popup'),
    btnAgregar = document.getElementById('agregar');


btnAbrirPopup.addEventListener('click', function(){
    formulario.reset();
    overlay.classList.add('active');
    popup.classList.add('active');
});

btnCerrarPopup.addEventListener('click',function(){
     formulario.reset();
    
    popup.classList.remove('active');
    overlay.classList.remove('active');
    
});

//btnAgregar.addEventListener('click',function(){
//     formulario.reset();
//});