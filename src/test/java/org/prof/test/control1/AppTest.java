package org.prof.test.control1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest 
{
	
    @Test
    @DisplayName("Test1: El vector de asignaturas no puede ser nulo")
    public void vectorAsignaturasNulo_ThrowException()
    {
    	Matricula mat = new Matricula(null);
        assertThrows(Exception.class, ()->mat.getImporte(), "No se lanza Exception cuando el vector es nulo");
    }
    
    @Test
    @DisplayName("Test2: Calcular importe del vector de asignaturas")
    public void calculaimporteMatricula() throws Exception
    {
    	
    	Asignatura a1 = mock(Asignatura.class);
    	Asignatura a2 = mock(Asignatura.class);
    	Vector<Asignatura> vectorAsignaturas = new Vector<>();
    	
    	vectorAsignaturas.add(a1);
    	vectorAsignaturas.add(a2);
    	
    	Matricula mat = new Matricula(vectorAsignaturas);
    	
    	when(a1.getImporte()).thenReturn(1.0);
    	when(a2.getImporte()).thenReturn(2.0);
    	
        assertEquals(3.0, mat.getImporte(), "Suma de los importe no correcta: importe1 + importea2 != 3.0");
    }
    
    
    @Test
    @DisplayName("Test3: Se recorren todas las asignaturas al calcular su importe")
    public void getImporteRecorreTodasLasAsignaturas() throws Exception
    {
    	
    	Asignatura a1 = mock(Asignatura.class);
    	Asignatura a2 = mock(Asignatura.class);
    	Asignatura a3 = mock(Asignatura.class);
    	Vector<Asignatura> vectorAsignaturas = new Vector<>();
    	
    	vectorAsignaturas.add(a1);
    	vectorAsignaturas.add(a2);
    	vectorAsignaturas.add(a3);
    	
    	Matricula mat = new Matricula(vectorAsignaturas);
    	
    	when(a1.getImporte()).thenReturn(1.0);
    	when(a2.getImporte()).thenReturn(2.0);
    	when(a3.getImporte()).thenReturn(3.0);
    	
    	mat.getImporte();
    	
    	verify(a1,times(1)).getImporte();
    	verify(a2,times(1)).getImporte();
    	verify(a3,times(1)).getImporte();
        
    }
    
}
