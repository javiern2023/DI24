from tkinter import *
raiz=Tk()
raiz.title("Ventana de prueba")
#RadioButton, usados normalmente para seleccionar sólo una opción
varOpcion=IntVar()
#Variables para los check
primero=IntVar()
segundo=IntVar()
tercero=IntVar()

def mostrarButton():
    print(varOpcion.get())
    if varOpcion.get()==1:
        etiqueta.config(text="Estas en primero")
    elif varOpcion.get()==2:
        etiqueta.config(text="Estas en segundo")
    else:
        etiqueta.config(text="Estas en tercero")

Label(raiz, text="Curso:").pack()

Radiobutton(raiz, text="Primero",variable=varOpcion, value=1, command=mostrarButton).pack()
Radiobutton(raiz, text="Segundo",variable=varOpcion, value=2, command=mostrarButton).pack()
Radiobutton(raiz, text="Tercero",variable=varOpcion, value=3, command=mostrarButton).pack()
etiqueta=Label(raiz)
etiqueta.pack()

def cursoCkeck():
    opcionSeleccionada=""
    if(primero.get()==1):
        opcionSeleccionada+=" primero"
    if(segundo.get()==1):
        opcionSeleccionada+=" segundo"
    if(tercero.get()==1):
        opcionSeleccionada+=" tercero"
        
    etiqueta2.config(text=opcionSeleccionada) 
                
frame=Frame(raiz)
frame.pack()
Label(frame, text="Elige curso", width=60).pack()

Checkbutton(frame, text="Primero", variable=primero, onvalue=1, offvalue=0, command=cursoCkeck).pack()
Checkbutton(frame, text="Segundo", variable=segundo, onvalue=1, offvalue=0, command=cursoCkeck).pack()
Checkbutton(frame, text="Tercero", variable=tercero, onvalue=1, offvalue=0, command=cursoCkeck).pack()

etiqueta2=Label(frame)
etiqueta2.pack()

raiz.mainloop()
