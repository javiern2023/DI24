from tkinter import *
#Para poder usar ventanas emergentes 
from tkinter import messagebox
raiz=Tk()
raiz.title("Ventana de menus")

def ventanaAbrir():
    messagebox.showinfo("Ventana emergente", "Boton de abrir")

def ventanaNuevo():
    messagebox.showwarning("Ventana emergente", "No se puede crear")

def ventanaGuardar():
    messagebox.showerror("Ventana emergente", "No se puede guardar")
    
def ventanaSalir():
    #Este metodo devuelvo yes o no
    valor=messagebox.askquestion("Ventana Salir", "Desea salir de la aplicacion")
    #valor=messagebox.askokcancel("Ventana Salir", "Desea salir de la aplicacion")
    if valor=="yes":
        raiz.destroy()

def ventanaCerrar():
    valor=messagebox.askretrycancel("Ventana Cerrar", "No es posible cerrar")
    
    if valor==False:
        raiz.destroy()

barraMenu=Menu(raiz)
raiz.config(menu=barraMenu, width=300, height=300)

#Indicamos cuántos elementos tiene nuestro menu
#tearoff quita las lineas de arriba en el menu
archivo=Menu(barraMenu, tearoff=0)
archivo.add_command(label="Nuevo", command=ventanaNuevo)
archivo.add_command(label="Abrir", command=ventanaAbrir)
archivo.add_command(label="Guardar", command=ventanaGuardar)
archivo.add_separator()
archivo.add_command(label="Cerrar", command=ventanaCerrar)
archivo.add_command(label="Salir", command=ventanaSalir)

editar=Menu(barraMenu)
herramientas=Menu(barraMenu)

#Texto de los elementos
barraMenu.add_cascade(label="Archivo", menu=archivo)
barraMenu.add_cascade(label="Editar", menu=editar)
barraMenu.add_cascade(label="Herramientas", menu=herramientas)

raiz.mainloop()