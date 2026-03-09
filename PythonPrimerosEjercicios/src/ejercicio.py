#Importar la libreria
from tkinter import *

#variable o ventana general
raiz=Tk()
#Titulo de la ventana
raiz.title("Ventana Principal")
#La ventana se redimensiona por defecto
#Si queremos que no se redimensiones. Podemos usar true o false
raiz.resizable(1, 1)
#Cambiar el icono. Descargar imagen con extensión .ico
raiz.iconbitmap("logo.ico")
#Tamaño de la ventana
raiz.geometry("400x100")
raiz.config(bg="red")
#Se crea el frame y se empaqueta dentro de la raiz
miFrame=Frame()
miFrame.pack()
miFrame.config(bg="blue")
#miFrame.config(width="650", heigth="350")
#Método bucle infinito para ejecutar las ventanas
raiz.mainloop()