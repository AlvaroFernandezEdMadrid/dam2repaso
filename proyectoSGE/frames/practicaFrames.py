import tkinter as tk
from PIL import Image, ImageTk

def main():
    root = tk.Tk()
    root.title("Práctica - Frames")
    root.geometry("600x400")  # Ajusta el tamaño de la ventana

    # Frame principal
    main_frame = tk.Frame(root)
    main_frame.pack(fill="both", expand=True)

    # Titulo superior
    tk.Label(main_frame, text="Práctica - Frames", bg="#B15B94", fg="white", font=("Arial", 25)).pack(fill="x", side="top")
    
    # Pie de página
    frame_pie = tk.Frame(root, bg="#B15B94")
    frame_pie.pack(fill="x", side="bottom")
    tk.Label(frame_pie, text="Alvaro", bg="#B15B94", fg="white", font=("Arial", 25), anchor="w").pack(fill="x", padx=10)

    # Frame izquierdo
    left_frame = tk.Frame(main_frame, bg="#C88AB3", padx=10)
    left_frame.pack(side="left", fill="y", expand=False)

    # Cargar la imagen
    image = Image.open("proyectoSGE/frames/ies.png")
    image = image.resize((120, 100))  # Redimensionar la imagen
    photo = ImageTk.PhotoImage(image)

    # Mostrar la imagen
    logo_label = tk.Label(left_frame, image=photo)
    logo_label.image = photo  # Mantener referencia
    logo_label.pack(pady=10)

    # Botones en el frame izquierdo
    tk.Button(left_frame, text="Ver Gráfica", bg="#B15B94", fg="white").pack(pady=20, side="top")
    tk.Button(left_frame, text="Datos Alumno", bg="#B15B94", fg="white").pack(pady=20, side="bottom")

    # Frame central
    center_frame = tk.Frame(main_frame)
    center_frame.pack(expand=True, fill="both")

    tk.Label(center_frame, text="I.E.S.\nVillablanca.\nCurso 24 - 25", bg="#DAB0CC", fg="white", font=("Arial", 25), justify="center").pack(expand=True, fill="both")

    root.mainloop()

if __name__ == "__main__":
    main()
