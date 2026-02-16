from tkinter import *

raiz = Tk()
raiz.title("Ventana de Registro")

miFrame = Frame(raiz, width=1200, height=600)
miFrame.pack()

# Variable
minombre = StringVar()
miContraseña = StringVar()

#########NOMBRE##############
cuadroNombre = Entry(miFrame, textvariable=minombre)
# grid. Metodo para crear una tabla
cuadroNombre.grid(row=0, column=1, padx=7, pady=7)
# configuración caracteristicas del label
cuadroNombre.config(fg="white", justify="center")

#########CONTRASEÑA##################
cuadroContraseña = Entry(miFrame, textvariable=miContraseña)
cuadroContraseña.grid(row=1, column=1, padx=7, pady=7)
cuadroContraseña.config(show="*", justify="center")

#########LABEL################
# Por defecto se alinean al centro. Sticky
nombreLabel = Label(miFrame, text="Usuario: ")
nombreLabel.grid(row=0, column=0, sticky="e", padx=7, pady=7)
contraseñaLabel = Label(miFrame, text="Contraseña: ")
contraseñaLabel.grid(row=1, column=0, sticky="e", padx=7, pady=7)

# Validación
etiqueta = Label(raiz)
etiqueta.pack()


# Funciones
def metodoValidar():
    if minombre.get() == "David" and miContraseña.get() == "123uem":
        etiqueta.config(fg="blue", text="Estas dentro")
    else:
        etiqueta.config(fg="red", text="Lo siento, datos incorrectos")


# Boton
botonValidar = Button(raiz, text="REGISTRAR", command=metodoValidar)
botonValidar.pack()

raiz.mainloop()
