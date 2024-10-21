'''
Created on 21 oct 2024

@author: usertar
'''
import tkinter as tk
from tkinter import ttk
from blinker._utilities import text

flag=False

ventana= tk.Tk()

ventana.title("Calculadora Pocha")

pantalla=ttk.Label(ventana,text="")
pantalla.grid(column=0,row=0)

def add1():
    # Obtener el texto actual y convertirlo a un número
    texto_actual = pantalla.cget("text")
    numero_actual = int(texto_actual)  # Convertir a entero
    # Sumar 1 al número
    nuevo_numero = numero_actual + 1
    # Actualizar el texto de la etiqueta
    pantalla.configure(text=str(nuevo_numero))
    
def add2():
    texto_actual = pantalla.cget("text")
    numero_actual = int(texto_actual)
    nuevo_numero = numero_actual + 2
    pantalla.configure(text=str(nuevo_numero))
    
def add3():
    texto_actual = pantalla.cget("text")
    numero_actual = int(texto_actual)
    nuevo_numero = numero_actual + 3
    pantalla.configure(text=str(nuevo_numero))
    
def add4():
    texto_actual = pantalla.cget("text")
    numero_actual = int(texto_actual)
    nuevo_numero = numero_actual + 4
    pantalla.configure(text=str(nuevo_numero))
    
def add5():
    texto_actual = pantalla.cget("text")
    numero_actual = int(texto_actual)
    nuevo_numero = numero_actual + 5
    pantalla.configure(text=str(nuevo_numero))
    
def add6():
    texto_actual = pantalla.cget("text")
    numero_actual = int(texto_actual)
    nuevo_numero = numero_actual + 6
    pantalla.configure(text=str(nuevo_numero))
    
def add7():
    texto_actual = pantalla.cget("text")
    numero_actual = int(texto_actual)
    nuevo_numero = numero_actual + 7
    pantalla.configure(text=str(nuevo_numero))
    
def add8():
    texto_actual = pantalla.cget("text")
    numero_actual = int(texto_actual)
    nuevo_numero = numero_actual + 8
    pantalla.configure(text=str(nuevo_numero))
    
def add9():
    texto_actual = pantalla.cget("text")
    numero_actual = int(texto_actual)
    nuevo_numero = numero_actual + 9
    pantalla.configure(text=str(nuevo_numero))
    
def add0():
    texto_actual = pantalla.cget("text")
    numero_actual = int(texto_actual)
    nuevo_numero = numero_actual + 0
    pantalla.configure(text=str(nuevo_numero))
    

Btn7=ttk.Button(ventana,text="7",command=add7)
Btn7.grid(column=0,row=1)

Btn4=ttk.Button(ventana,text="4",command=add4)
Btn4.grid(column=0,row=2)

Btn1=ttk.Button(ventana,text="1",command=add1)
Btn1.grid(column=0,row=3)



Btn8=ttk.Button(ventana,text="8",command=add8)
Btn8.grid(column=1,row=1)

Btn5=ttk.Button(ventana,text="5",command=add5)
Btn5.grid(column=1,row=2)

Btn2=ttk.Button(ventana,text="5",command=add5)
Btn2.grid(column=1,row=3)

Btn2=ttk.Button(ventana,text="0",command=add5)
Btn2.grid(column=1,row=4)


Btn8=ttk.Button(ventana,text="9",command=add9)
Btn8.grid(column=3,row=1)

Btn5=ttk.Button(ventana,text="6",command=add6)
Btn5.grid(column=3,row=2)

Btn2=ttk.Button(ventana,text="3",command=add3)
Btn2.grid(column=3,row=3)




ventana.mainloop()




