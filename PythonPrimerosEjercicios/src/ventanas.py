from tkinter import *

def ventana1():
    global ventana1
    ventana1 =Tk()
    ventana1.geometry("400x200")
    ventana1.title("Primera ventana")
    Button(ventana1, text="Ventana2",width=20,command=ventana2).place(relx=0.5, rely=0.5)
    ventana1.mainloop()


def ventana2():
    global ventana2
    ventana2 = Toplevel(ventana1)
    ventana2.geometry("400x200")
    ventana2.title("Segunda ventana")
    Button(ventana2, text="Ventana1",width=20, command=volver).place(relx=0.5, rely=0.5)
    if(ventana2):
        ventana1.withdraw()
    ventana2.mainloop()

def volver():
    ventana1.iconify()
    ventana1.deiconify()
    ventana2.destroy()    
ventana1()