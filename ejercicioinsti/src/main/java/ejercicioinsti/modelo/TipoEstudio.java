package ejercicioinsti.modelo;

public enum TipoEstudio {
	ESO(4), BACHILLER(2), FPGM(2), FPGS(2);
	
	private final int numCursos;
	
	TipoEstudio(int numCursos){this.numCursos=numCursos;}
	
	public int getNumCursos() {
		return numCursos;
	}
	
	public boolean isCursoValido(int curso) {
        return curso >= 1 && curso <= numCursos;
    }
}
