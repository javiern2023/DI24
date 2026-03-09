from tkinter import *
raiz=Tk()
miFrame=Frame(raiz, width=500, height=400)
miFrame.pack()

#Puedo añadir propiedades al label
miLabel=Label(miFrame,text="Hello", fg="pink", font=("Arial",35))
#ubica el label en una posición
miLabel.place(x=2,y=2)

miImagen=PhotoImage(file="Universidad.png")
Label(miFrame, image=miImagen).place(x=10, y=10)

raiz.mainloop()