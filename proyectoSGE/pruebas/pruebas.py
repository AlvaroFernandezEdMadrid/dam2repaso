'''
Created on 21 oct 2024

@author: usertar
'''

import tkinter as tk
from tkinter import ttk

flag=False

ventana= tk.Tk()

ventana.title("Poronga")

lblTag=ttk.Label(ventana,text="jajaSalu2")
lblTag.grid(column=0,row=0)

def funcionPrueba():
    global flag
    if flag==True:
        btnTag.configure(text="Pulsaste pto")
    else:
        btnTag.configure(text="Pulsa we")
        flag=not flag

btnTag=ttk.Button(ventana,text="pulsa aqui",command=funcionPrueba)
btnTag.grid(column=0,row=1)


ventana.mainloop()

