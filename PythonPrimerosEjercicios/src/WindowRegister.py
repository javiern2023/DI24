from tkinter import *
from tkinter import messagebox

# Función que da estilos a los labels del frame de registro
def configRegisterLabel(etiqueta):
    etiqueta.config(background="#393E41", foreground="#F1FEC6", font="Calibri")
    
# Función que da estilos a los labels del frame de login
def configLoginLabel(etiqueta):
    etiqueta.config(background="#FF3A20", foreground="#F1FEC6", font="Calibri")

# Función que muestra un mensaje cuando se pulsa sobre el button 'registrarse'
def mostrarMensajeRegistroExitoso():
    messagebox.showinfo("Registro Exitoso", "¡El registro ha sido efectuado correctamente!")

# Función que muestra un mensaje cuando se pulsa sobre el button 'Iniciar sesión'
def mostrarMensajeInicioSesionExitoso():
    messagebox.showinfo("Inicio de Sesión", "¡Ha iniciado sesión correctamente!")

# Almacenamiento de los datos con los que el usuario se registra
datos_registro = {}

# Función que muestra el mensaje en la pantalla de registro
def functionalityRegister():
    # Obtener los valores de los campos de registro
    nameRegister = inputName.get()
    mailRegister = inputMail.get()
    passwodRegister = inputPass.get()
    
    # Verificar si alguno de los campos está vacío
    if nameRegister == '' or mailRegister == '' or passwodRegister == '':
        messagebox.showwarning("Campos Vacíos", "Debe rellenar todos los campos.")
    else:
        datos_registro['nombre'] = nameRegister
        datos_registro['email'] = mailRegister
        datos_registro['password'] = passwodRegister
        mostrarMensajeRegistroExitoso()
        # Limpiar campos después de un registro exitoso
        inputName.delete(0, 'end')
        inputMail.delete(0, 'end')
        inputPass.delete(0, 'end')
        
    
# Función que muestra el mensaje en la pantalla de login
def functionalityLogin():
    # Obtener los valores de los campos de inicio de sesión
    nameLogin = inputNameLogin.get()
    mailLogin = inputMailLogin.get()
    passwordLogin = inputPassLogin.get()

    # Verificar si alguno de los campos está vacío y también que los datos de registro coincidan con los de login
    if nameLogin == '' or mailLogin == '' or passwordLogin == '':
        messagebox.showwarning("Campos Vacíos", "Debe rellenar todos los campos.")  
    else:
        if nameLogin == datos_registro.get('nombre') and mailLogin == datos_registro.get('email') and passwordLogin == datos_registro.get('password'):
            mostrarMensajeInicioSesionExitoso()
            # Limpiar campos después de un inicio de sesión exitoso
            inputNameLogin.delete(0, 'end')
            inputMailLogin.delete(0, 'end')
            inputPassLogin.delete(0, 'end')
        else:
            messagebox.showerror("Error de Inicio de Sesión", "Los datos de inicio de sesión no coinciden.")
            # Limpiar campos después de un intento de inicio de sesión fallido
            inputNameLogin.delete(0, 'end')
            inputMailLogin.delete(0, 'end')
            inputPassLogin.delete(0, 'end')
    

raiz = Tk()
raiz.title("User registration and login")
#raiz.iconbitmap("C:\\Users\\chpal\\OneDrive\\Escritorio\\Código\\Desarrollo de interfaces\\VentanaRegistroPython\\user.ico")
# Frame de registro que va a contener labels, forumulario y button registrarse.
FrameRegister = Frame(raiz, width=800, height=400)
FrameRegister.pack(side="left", anchor="n")
FrameRegister.config(background="#393E41", padx=25, pady=25)

# Inputs del frame registro
inputName = Entry(FrameRegister)
inputName.grid(row=0, column=1, padx=10)

inputMail = Entry(FrameRegister)
inputMail.grid(row=1, column=1, padx=10)

inputPass = Entry(FrameRegister)
inputPass.grid(row=2, column=1, padx=10)
inputPass.config(show="*")

# Labels de los inputs del frame de registro
nameLabel = Label(FrameRegister, text="Nombre:")
nameLabel.grid(row=0, column=0, sticky="w", padx=5, pady=5)

emailLabel = Label(FrameRegister, text="Email:")
emailLabel.grid(row=1, column=0, sticky="w", padx=5, pady=5)

passwordLabel = Label(FrameRegister, text="Contraseña:")
passwordLabel.grid(row=2, column=0, sticky="w", padx=5, pady=5)

# Llamada a la funcion que aplica mismos estilos a todos los labels
configRegisterLabel(nameLabel)
configRegisterLabel(emailLabel)
configRegisterLabel(passwordLabel)

# Button de registro dentro del frame de registro
buttonRegister = Button(FrameRegister, text="Registrarse", command=functionalityRegister)
buttonRegister.grid(row=4, column=1, pady=8)
buttonRegister.config(background="#FF3A20", foreground="#F1FEC6", width=13, border=3, relief="raised", activebackground="#CCD6EB", cursor="hand2")




# Frame de login que va a contener labels, formulario y button iniciar sesión.
FrameLogin = Frame(raiz, width=800, height=400)
FrameLogin.pack(side="right", anchor="n")
FrameLogin.config(background="#FF3A20", padx=25, pady=25)

# Inputs del frame login
inputNameLogin = Entry(FrameLogin)
inputNameLogin.grid(row=0, column=1, padx=10)

inputMailLogin = Entry(FrameLogin)
inputMailLogin.grid(row=1, column=1, padx=10)

inputPassLogin = Entry(FrameLogin)
inputPassLogin.grid(row=2, column=1, padx=10)
inputPassLogin.config(show="*")

# Labels de los inputs del frame de login
nameLabelLogin = Label(FrameLogin, text="Nombre:")
nameLabelLogin.grid(row=0, column=0, sticky="w", padx=5, pady=5)

emailLabelLogin = Label(FrameLogin, text="Email:")
emailLabelLogin.grid(row=1, column=0, sticky="w", padx=5, pady=5)

passwordLabelLogin = Label(FrameLogin, text="Contraseña:")
passwordLabelLogin.grid(row=2, column=0, sticky="w", padx=5, pady=5)

# Llamada a la funcion que aplica mismos estilos a todos los labels
configLoginLabel(nameLabelLogin)
configLoginLabel(emailLabelLogin)
configLoginLabel(passwordLabelLogin)

# Button de login dentro del frame de login
buttonLogin = Button(FrameLogin, text="Iniciar sesión", command=functionalityLogin)
buttonLogin.grid(row=4, column=1, pady=8)
buttonLogin.config(background="#393E41", foreground="#F1FEC6", width=13, border=3, relief="raised", activebackground="#CCD6EB", cursor="hand2")

raiz.mainloop()