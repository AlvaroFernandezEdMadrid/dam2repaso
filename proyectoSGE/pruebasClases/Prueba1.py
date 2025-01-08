class Alumno():
    def __init__(self, nombre, dni, curso, nota):
        self.__nombre=nombre
        self.__dni=dni
        self.__curso=curso
        self.__nota=nota
        
    def getNombre(self):
        return self.__nombre
    
    def getDni(self):
        return self.__dni
    
    def getCurso(self):
        return self.__curso
    
    def getNota(self):
        return self.__nota
    
    def isAprobado(self):
        loEsta=True
        
        if(self.__nota<5):
            loEsta=False
        
        return loEsta
    
    def mostrarDatos(self):
        print("Nombre: "+self.getNombre()
              +"\nDNI: "+self.getDni()
              +"\nCurso: "+str(self.getCurso())
              +"\nNota:"+str(self.getNota())
              +"\nAprobado: "+str(self.isAprobado()))
    

class AlumnoDAM(Alumno):
    def __init__(self, nombre, dni, curso, nota, lenguajePreferido):
        super().__init__(nombre, dni, curso, nota)
        self.__lenguajePreferido=lenguajePreferido
        
    def mostrarDatos(self):
        super().mostrarDatos()
        print("Lenguaje Preferido: " + self.__lenguajePreferido)


al1=Alumno("Paco","123",3, 4)

al2=AlumnoDAM("Antonio", "444", 2, 7, "Java")

al1.mostrarDatos()

al2.mostrarDatos()

