using Practica4;
using System;
using Xamarin.Forms;


namespace Practica4
{
    public partial class MainPage : ContentPage
    {
        String usuario = "Carlos Obed";
        String contraseña = "@Parcial2";
        public MainPage()
        {
            InitializeComponent();
        }

        private void validarUsuario()
        {
            var isUservalid = !string.IsNullOrEmpty(txtUser.Text);
            var isPasswordvalid = !string.IsNullOrEmpty(txtPassword.Text);
            if (isUservalid && isPasswordvalid)
            {
                if (txtUser.Text == usuario && txtPassword.Text == contraseña) {
                    DisplayAlert("Message", "Bienvenido", "Aceptar");
                    Navigation.PushAsync(new ConfirmPage());
                }else
                {
                    DisplayAlert("Alert", "Error al iniciar sesion", "Cancelar");
                    Navigation.PushAsync(new DenegatePage());
                }
            }
            else
            {
                DisplayAlert("Alert", "Error al iniciar sesion", "Cancelar");
            }
        }

        private void Button_Clicked(object sender, EventArgs e)
        {
            validarUsuario();
        }
    }
}
