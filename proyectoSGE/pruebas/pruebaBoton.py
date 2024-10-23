'''
Created on 22 oct 2024

@author: usertar
'''
import tkinter as tk
from tkinter import ttk, Toplevel

ventana= tk.Tk()

ventana.title("Botoncito")
    
texto=tk.StringVar(ventana,"Introduce tu nombre")
    
entry=tk.Entry(ventana, textvariable=texto)
entry.grid(column=0,row=0)

def ponerNombre():
    boton.configure(text="Hola "+entry.get())

boton=ttk.Button(ventana, text="Pulsa", command=ponerNombre)
boton.grid(column=1,row=0)

#854x480

dondeW=(ventana.winfo_screenwidth()/2)-(854/2)
dondeH=(ventana.winfo_screenheight()/2)-(480/2)

ventana.geometry(f'854x480+{int(dondeW)}+{int(dondeH)}')


ventana.mainloop()


