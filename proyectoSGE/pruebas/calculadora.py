'''
Created on 21 oct 2024

@author: afl
'''
import tkinter as tk
from tkinter import ttk

ventana= tk.Tk()

ventana.title("Calculadora Pocha")
#ventana.geometry("500x500")

pantalla=ttk.Label(ventana,text="")
pantalla.grid(column=0,row=0, columnspan=5)

def add(valor):
    texto_actual = pantalla.cget("text")
    texto_actual += str(valor)
    pantalla.configure(text=texto_actual)
   
def borrar(): 
    pantalla.configure(text="")
    
def calcular():
    texto_actual = pantalla.cget("text")
    try:
        resultado = eval(texto_actual)
        pantalla.configure(text=str(resultado))
    except Exception as e:
        pantalla.configure(text="Error")
    

#Columna 0

BtnBorrar=ttk.Button(ventana,text="C",command=borrar)
BtnBorrar.grid(column=0,row=1)

Btn7=ttk.Button(ventana,text="7",command=lambda: add(7))
Btn7.grid(column=0,row=2)

Btn4=ttk.Button(ventana,text="4",command=lambda: add(4))
Btn4.grid(column=0,row=3)

Btn1=ttk.Button(ventana,text="1",command=lambda: add(1))
Btn1.grid(column=0,row=4)


#Columna 1
Btn8=ttk.Button(ventana,text="8",command=lambda: add(8))
Btn8.grid(column=1,row=2)

Btn5=ttk.Button(ventana,text="5",command=lambda: add(5))
Btn5.grid(column=1,row=3)

Btn2=ttk.Button(ventana,text="2",command=lambda: add(2))
Btn2.grid(column=1,row=4)

Btn2=ttk.Button(ventana,text="0",command=lambda: add(0))
Btn2.grid(column=1,row=5)

#Columna 2
Btn8=ttk.Button(ventana,text="9",command=lambda: add(9))
Btn8.grid(column=3,row=2)

Btn5=ttk.Button(ventana,text="6",command=lambda: add(6))
Btn5.grid(column=3,row=3)

Btn2=ttk.Button(ventana,text="3",command=lambda: add(3))
Btn2.grid(column=3,row=4)

BtnDec=ttk.Button(ventana,text=".",command=lambda: add("."))
BtnDec.grid(column=3,row=5)

#Columna 3

BtnSuma=ttk.Button(ventana,text="+",command=lambda: add("+"))
BtnSuma.grid(column=4,row=1)

BtnResta=ttk.Button(ventana,text="-",command=lambda: add("-"))
BtnResta.grid(column=4,row=2)

BtnMulti=ttk.Button(ventana,text="*",command=lambda: add("*"))
BtnMulti.grid(column=4,row=3)

BtnDivi=ttk.Button(ventana,text="/",command=lambda: add("/"))
BtnDivi.grid(column=4,row=4)

BtnTotal=ttk.Button(ventana,text="=",command=calcular)
BtnTotal.grid(column=4,row=5)



ventana.mainloop()




