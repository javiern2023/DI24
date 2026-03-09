from tkinter import *
from tkinter import messagebox

raiz=Tk()
raiz.title("Ventana de registro")

#Mismas caracteristicas que el frame
miFrame=Frame(raiz,width=1800,height=900)
miFrame.pack()

def metodoSalir():
    raiz.destroy()

def comprobarCampos():
    if cuadroNombre.get()=="":
        messagebox.showinfo("Ventana emergente", "Inserte el nombre")
    elif cuadroContrasena.get()=="":
        messagebox.showinfo("Ventana emergente", "Inserte la contraseña")
    elif cuadroNombre.get()=="Javier" and cuadroContrasena=="admin":
        messagebox.showinfo("Ventana emergente", "Estas dentro")

#variable
minombre=StringVar()

cuadroNombre=Entry(miFrame)
#grid.Metodo que permite crear una tabla(frame)
cuadroNombre.grid(row=0,column=1,padx=7, pady=7)
#config. Metodo configuración caracteristicas del contenido label
cuadroNombre.config(fg="blue", justify="center")
cuadroContrasena=Entry(miFrame)
cuadroContrasena.grid(row=1,column=1,padx=7, pady=7)
cuadroContrasena.config(show="*")
#Por defecto se alinean al centro.Sticky
nombreLabel=Label(miFrame, text="Nombre:")
nombreLabel.grid(row=0,column=0,sticky="e",padx=7, pady=7)
passLabel=Label(miFrame, text="Contraseña:")
passLabel.grid(row=1,column=0,sticky="e",padx=7, pady=7)

#Botones
botonMostrar=Button(miFrame, text="Entrar", command=comprobarCampos)
botonMostrar.grid(row=2,column=0,sticky="nesw",padx=7, pady=7)
botonSalir=Button(miFrame, text="Salir", command=metodoSalir)
botonSalir.grid(row=2,column=1,sticky="nesw",padx=7, pady=7)
#miImagen=PhotoImage(file="logo.png")
#Label(miFrame, image=miImagen).grid(row=0,column=3,sticky="nesw",padx=1, pady=1)


#Funciones
#def metodoBoton():
    #if minombre.get()=="":
    #minombre.set("Javier")
    #else:
    




    
raiz.mainloop()