package com.mycompany.P1Lab2LopezRayson;


public  class Libro_LopezRayson {
	private String title,autor,genero;
	private long ISBN;
	private String anioPublicacion;
	private boolean disponibilidad;
	
	public Libro_LopezRayson(String title,String autor,long ISBN,String anioPublicacion,String genero) {
		this.title=title;
		this.autor=autor; 
		this.ISBN=ISBN;
		this.anioPublicacion=anioPublicacion;
		this.genero=genero;
		this.disponibilidad = false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public String getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(String anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
    public boolean isPrestado() {
        return disponibilidad;
    }

    public void setPrestado(boolean prestado) {
        this.disponibilidad = prestado;
    }
    
    @Override
    public String toString() {
        return "Libro: " + title + ", Autor: " + autor + ", Género: " + genero +
                ", ISBN: " + ISBN + ", Fecha de Publicación: " + anioPublicacion +
                ", Estado: " + (disponibilidad ? "Disponible" : "No disponible");
    }
}
