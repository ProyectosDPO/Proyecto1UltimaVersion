package modelo;

import procesamiento.Archivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Vehiculo {
	private String placa;
	private String marca;
	private String modelo;
	private String color;
	private String categoria;
	private String estado;
	private String sedeActual;
	private List<String> historial;
	
	
	public void ejecutarVehiculos(Map<String, Vehiculo> carroMap)
	{
		boolean continuar = true;
		while (continuar) {

			System.out.println("\n\n-------------Opciones de usuario-------------\n\n");
			System.out.println("1.Consultar Inventario Total de Vehiculos (Son mas de 100)"
					+ "\n2.Consultar Vehiculos de Sede Especifica"
					+ "\n3.Consultar Vehiculos de Categoria Especifica"
					+ "\n4.Consultar Vehiculo Especifico"
					+ "\n5.Añadir Vehiculo al Inventario"
					+ "\n6.Eliminar Vehiculo del Inventario"
					+ "\n7.Salir del Menu de Vehiculos ");
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1) {
				System.out.println("Opcion 1: Consultar Inventario de Vehiculos");
				showInventario(carroMap);
				@SuppressWarnings("unused")
				String hacertiempo = (input("Click para continuar"));
			}
			if (opcion_seleccionada == 2) {
				System.out.println("Opcion 2:  Consultar Vehiculos de Sede Especifica");
				String sede = input("\n\nIngrese Sede a buscar ->");
				showCarrosSede(carroMap,sede);
				@SuppressWarnings("unused")
				String hacertiempo = (input("Click para continuar"));
			}
			if (opcion_seleccionada == 3) {
				System.out.println("Opcion 3: Consultar Vehiculos de Categoria Especifica");
				String categoria = input("\n\nIngrese Categoria a buscar ->");
				showCarrosCategoria(carroMap,categoria);
				@SuppressWarnings("unused")
				String hacertiempo = (input("Click para continuar"));
			}
			if (opcion_seleccionada == 4) {
				System.out.println("Opcion 4: Consultar Vehiculo Especifico");
				String placa = input("\n\nIngrese Placa del Vehiculo ->");
				showCarroEspecifico(carroMap,placa);
				@SuppressWarnings("unused")
				String hacertiempo = (input("Click para continuar"));
			}
			if (opcion_seleccionada == 5) {
				System.out.println("Opcion 5: Añadir Vehiculo al Inventario");
				
			}
			if (opcion_seleccionada == 6) {
				System.out.println("Opcion 6: Eliminar Vehiculo del Inventario");
				
				@SuppressWarnings("unused")
				String hacertiempo = (input("Se han guardado los cambios en el archivo Sedes.csv "
						+ "\n\nClick para continuar"));
			}

			if (opcion_seleccionada == 7) {
				System.out.println("Saliendo del Menu...\n\n...");
				continuar = false;
			}
			
			
		}
		
		
		
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setSedeActual(String sedeActual) {
		this.sedeActual = sedeActual;
	}

	public Vehiculo (String laplaca,String lamarca, String elmodelo,String elcolor,
			String lacategoria, String laSede) {
		this.placa = laplaca;
		this.marca = lamarca;
		this.modelo = elmodelo;
		this.color = elcolor;
		this.categoria = lacategoria;
		this.sedeActual = laSede;
		this.estado = "disponible";
		this.historial = Collections.<String>emptyList();	
	}
	
	public void crearNuevoVehiculo(Map<String, Vehiculo> carroMap) {
		String placa = (input("Placa del vehiculo "));
		String marca = (input("Marca del vehiculo "));
		String modelo = (input("Modelo del vehiculo "));
		String color = (input("Color del vehiculo "));
		String categoria = (input("Categoria del vehiculo "));
		String sede = (input("Sede del vehiculo "));
		
		Vehiculo nuevoVehiculo = new Vehiculo (placa,marca,modelo,color,categoria,sede);
		carroMap.put(placa, nuevoVehiculo);
		
	}
	
	
	
	


	
	public void showCarrosDisponibles2(Map<String, Vehiculo> carroMap,String categoriabuscada,
			String sedebuscada) 
	{
	System.out.println("\n\nCARROS DISPONIBLES QUE CUMPLEN CON CATEGORIA Y SEDE:\n\n");
	System.out.println("+---------------------------------------+");
	for (Map.Entry<String, Vehiculo> entry : carroMap.entrySet())
	{
		Vehiculo carro = entry.getValue();
		if (carro.getCategoria().equals(categoriabuscada)&&carro.getSedeActual().equals(sedebuscada))
		 {
			System.out.println("Marca:"+carro.getMarca());
			System.out.println("Modelo:"+carro.getModelo());
			System.out.println("Placa:"+carro.getPlaca());
			System.out.println("+---------------------------------------+");
		}
 	}
 	}
	
	public void showCarrosSede(Map<String, Vehiculo> carroMap,
			String sedebuscada) 
	{
	System.out.println("\n\nCARROS DISPONIBLES QUE CUMPLEN CON CATEGORIA Y SEDE:\n\n");
	System.out.println("+---------------------------------------+");
	for (Map.Entry<String, Vehiculo> entry : carroMap.entrySet())
	{
		Vehiculo carro = entry.getValue();
		if (carro.getSedeActual().equals(sedebuscada))
		 {
			System.out.println("Marca:"+carro.getMarca());
			System.out.println("Modelo:"+carro.getModelo());
			System.out.println("Placa:"+carro.getPlaca());
			System.out.println("Categoria:"+carro.getCategoria());
			System.out.println("+---------------------------------------+");
		}
 	}
 	}
	
	public void showCarrosCategoria(Map<String, Vehiculo> carroMap,
			String categoriabuscada) 
	{
	System.out.println("\n\nCARROS DISPONIBLES QUE CUMPLEN CON CATEGORIA Y SEDE:\n\n");
	System.out.println("+---------------------------------------+");
	for (Map.Entry<String, Vehiculo> entry : carroMap.entrySet())
	{
		Vehiculo carro = entry.getValue();
		if (carro.getCategoria().equals(categoriabuscada))
		 {
			System.out.println("Marca:"+carro.getMarca());
			System.out.println("Modelo:"+carro.getModelo());
			System.out.println("Placa:"+carro.getPlaca());
			System.out.println("Sede:"+carro.getSedeActual());
			System.out.println("+---------------------------------------+");
		}
 	}
 	}
	
	public void showInventario(Map<String, Vehiculo> carroMap)
	{
		System.out.println("\n\nINVENTARIO TOTAL:\n\n");
		for (Map.Entry<String, Vehiculo> entry : carroMap.entrySet())
		{
			Vehiculo carro = entry.getValue();
				System.out.println("Marca:"+carro.getMarca());
				System.out.println("Modelo:"+carro.getModelo());
				System.out.println("Placa:"+carro.getPlaca());
				System.out.println("+---------------------------------------+");
	 	}
	}
	
	public void showCarroEspecifico(Map<String, Vehiculo> carroMap,String placa)
	{
		System.out.println("\n\n"+placa+"\n\n");
		if (carroMap.containsKey(placa)){
			Vehiculo carro = carroMap.get(placa);
			System.out.println("Marca:"+carro.getMarca());
			System.out.println("Modelo:"+carro.getModelo());
			System.out.println("Color:"+carro.getColor());
			System.out.println("Placa:"+carro.getPlaca());
			System.out.println("Sede:"+carro.getSedeActual());
			System.out.println("Categoria:"+carro.getCategoria());
			System.out.println("Historial:"+carro.getHistorial());
			
			
			System.out.println("+---------------------------------------+");
 	}
		else
		{System.out.println("No se ha encontrado el carro");}
		
		
	}
	
	
	
	
	
	
	
	public String getColor() {
		return color;
	}

	public List<String> getHistorial() {
		return historial;
	}

	public String getPlaca() {
		return placa;
	}
	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getSedeActual() {
		return sedeActual;
	}

	public String input(String mensaje) {
		try {
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
}


