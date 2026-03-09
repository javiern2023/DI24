from tkinter import *
from tkinter import ttk
raiz=Tk()
raiz.title("Ventana comboBox")

def mostrar():
    opcionSeleccionada="Tu nombre es "
    opcionSeleccionada+=combo.get()
    etiqueta.config(text=opcionSeleccionada)



Label(raiz, text="Elige nombre", width=40).pack()
combo=ttk.Combobox(raiz)

#Comienzo con valor vacío
combo['values'] = ('Javier','Ainhoa','Izan')
#Inicar con valor indicando índice. Empieza en 0
combo.current(1)
combo.pack()

boton = Button(raiz,command=mostrar,text="Mostrar").pack()

etiqueta=Label(raiz)
etiqueta.pack()


raiz.mainloop()
