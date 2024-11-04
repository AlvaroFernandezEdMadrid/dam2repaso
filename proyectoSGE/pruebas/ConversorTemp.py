'''
Created on 4 nov 2024

@author: usertar
'''
import tkinter as tk
from tkinter import ttk

ventana= tk.Tk()

ventana.title("Conversor")

ventana.geometry("854x480")

inputLb=ttk.Label(ventana, text="Temp. en Cº: ")
inputLb.grid(column=0,row=0)

entrada=ttk.Entry(ventana,width=30)
entrada.grid(column=1,row=0)

radF=ttk.Radiobutton(ventana, text="Farenheit")
radF.grid(column=0,row=1)

radK=ttk.Radiobutton(ventana, text="Kelvin")
radK.grid(column=0,row=2)

def calcular():
    



butConvertir=ttk.Button(ventana, text="Convertir", command=calcular)
butConvertir.grid(column=0,row=3)

lablRes=ttk.Label(ventana, text="")
lablRes.grid(column=0,row=4)


    

ventana.mainloop()