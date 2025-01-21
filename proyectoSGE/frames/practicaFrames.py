import tkinter as tk
from tkinter import ttk
import os

def main():
    root = tk.Tk()
    root.title("Práctica - Frames")
    root.geometry("600x400")  # Ajusta el tamaño de la ventana

    # Frame principal
    main_frame = ttk.Frame(root, relief="solid")
    main_frame.pack(fill="both", expand=True)

    # Título superior
    title_label = tk.Label(main_frame, text="Práctica - Frames", bg="#D28EB0", fg="white", font=("Arial", 25, "bold"))
    title_label.pack(fill="both", side="top")

    # Frame izquierdo
    left_frame = ttk.Frame(main_frame, relief="solid")
    left_frame.place(x=10, y=50, width=150, height=300)

    # Logo y botones en el frame izquierdo
    logo_label = tk.Label(left_frame)
    try:
        # Construir la ruta de la imagen
        photo_path = os.path.join(os.getcwd(), "proyectoSGE", "frames", "ies.png")
        original_photo = tk.PhotoImage(file=photo_path)

        # Redimensionar la imagen para que encaje en el frame
        resized_photo = original_photo.subsample(4, 4)  # Reducir el tamaño a 1/4
        logo_label.config(image=resized_photo)
        logo_label.image = resized_photo  # Guardar referencia para evitar que se descarte

    except tk.TclError as e:
        print(f"Error al cargar la imagen: {e}")
        logo_label.config(text="Imagen no disponible", font=("Arial", 10))

    logo_label.pack(pady=10)

    graph_button = tk.Button(left_frame, text="Ver Gráfica", bg="#D28EB0", fg="white")
    graph_button.pack(pady=20, fill="x")

    data_button = tk.Button(left_frame, text="Datos Alumno", bg="#D28EB0", fg="white")
    data_button.pack(pady=20, fill="x")

    # Frame central
    center_frame = ttk.Frame(main_frame, relief="solid")
    center_frame.place(x=170, y=50, width=400, height=300)

    center_label = tk.Label(center_frame, text="I.E.S.\nVillablanca.\nCurso 24 - 25", bg="#D28EB0", fg="white", font=("Arial", 14, "bold"), justify="center")
    center_label.pack(expand=True, fill="both")

    # Pie de página
    footer_label = tk.Label(main_frame, text="Nombre del Alumno", bg="#D28EB0", fg="white", font=("Arial", 12))
    footer_label.pack(fill="x", side="bottom")

    root.mainloop()

if __name__ == "__main__":
    main()
