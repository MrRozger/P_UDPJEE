package com.politechnika.Projekt_UDPJEE;

import com.politechnika.Projekt_UDPJEE.model.Address;
import com.politechnika.Projekt_UDPJEE.model.BClient;
import com.politechnika.Projekt_UDPJEE.model.SClient;
import com.politechnika.Projekt_UDPJEE.model.Vehicle;
import com.politechnika.Projekt_UDPJEE.repository.ClientRepository;
import com.politechnika.Projekt_UDPJEE.repository.ReservationRepository;
import com.politechnika.Projekt_UDPJEE.repository.RoomRepository;
import com.politechnika.Projekt_UDPJEE.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ProjektUdpjeeApplicationTests {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private ReservationRepository reservationRepository;

	@Test
	void contextLoads() {
	}


	@Test
	public void SaveGUser(){
		Maid maid = createDefaultMaid();
		Room room = createDefaultRoom(maid);
		GClient gcLient =  createGClient("Michal","Lulak", createDefaultAddress(),createDefaultVehicle());
		createReservation(gcLient,room);

	}


	@Test
	public void SaveSUser(){
		Maid maid = createDefaultMaid();
		Room room = createDefaultRoom(maid);
		SClient sClient = createSClient("Bartek","Rozga", createDefaultAddress(),createDefaultVehicle());
		createReservation(sClient,room);

	}

	@Test
	public void SaveTwoClients(){

		Address address = new Address();
		address.setCity("Lodz");
		address.setStreet("Gorna");
		address.setHouseNumber(12);

		Address address2 = new Address();
		address2.setCity("Lodz");
		address2.setStreet("Gorna");
		address2.setHouseNumber(12);

		Vehicle vehicle = new Vehicle();
		vehicle.setModel("Ford Mondeo");
		vehicle.setType(Vehicle.Type.SPORT);

		Maid maid = new Maid();
		maid.setNickname("ONA");


		Room room = new Room();
		room.setNumber(109);
		room.setType(Room.Type.STANDARD);
		room.setMaid(maid);
		roomRepository.save(room);



		GClient gClient = new GClient();
		gClient.setFirstName("Michal");
		gClient.setLastName("Matusiak");
		gClient.setAddress(createDefaultAddress());
		gClient.setVehicle(vehicle);
		clientRepository.save(gClient);

		Reservation reservation = new Reservation();
		reservation.setData(LocalDateTime.now());
		reservation.setClient(gClient);
		reservationRepository.save(reservation);




		GClient gClient1 = new GClient();
		gClient1.setFirstName("Arek");
		gClient1.setLastName("Musial");
		gClient1.setAddress(address2);
		gClient1.setVehicle(vehicle);
		clientRepository.save(gClient1);


	}

	@Test
	public void FirstNameCannotBeNull(){
		GClient gClient1 = new GClient();
		gClient1.setFirstName(null);
		gClient1.setLastName("Musial");
		clientRepository.save(gClient1);
	}

	public GClient createGClient(String firstName, String lastName, Address address, Vehicle vehicle ){
		GClient gclient = new GClient();
		gclient.setFirstName(firstName);
		gclient.setLastName(lastName);
		gclient.setAddress(address);
		gclient.setVehicle(vehicle);
		return clientRepository.save(gclient);
	}

	public BClient createCClient(String firstName, String lastName, Address address, Vehicle vehicle ){
		BClient bclient = new BClient();
		bclient.setFirstName(firstName);
		bclient.setLastName(lastName);
		bclient.setAddress(address);
		bclient.setVehicle(vehicle);
		return clientRepository.save(bclient);
	}

	public SClient createSClient(String firstName, String lastName, Address address, Vehicle vehicle ){
		SClient sclient = new SClient();
		sclient.setFirstName(firstName);
		sclient.setLastName(lastName);
		sclient.setAddress(address);
		sclient.setVehicle(vehicle);
		return clientRepository.save(sclient);
	}

	public Address createDefaultAddress(){
		Address address = new Address();
		address.setCity("Lodz");
		address.setStreet("Lecznicza");
		address.setHouseNumber(5);
		return address;
	}

	public Room createDefaultRoom(Maid maid){
		Room room = new Room();
		room.setNumber(2);
		room.setType(Room.Type.APARTAMENT);
		room.setMaid(maid);
		return  roomRepository.save(room);

	}

	public Reservation createReservation(Client client, Room room){
		Reservation reservation = new Reservation();
		reservation.setData(LocalDateTime.now());
		reservation.setClient(client);
		reservation.setRoom(room);
		return reservationRepository.save(reservation);
	}

	public Maid createDefaultMaid(){
		Maid maid = new Maid();
		maid.setNickname("Natasha");
		return maid;
	}
	public Maid createDefaultMaid1(){
		Maid maid = new Maid();
		maid.setNickname("Milena");
		return maid;
	}

	public Vehicle createDefaultVehicle(){
		Vehicle vehicle = new Vehicle();
		vehicle.setType(Vehicle.Type.SPORT);
		vehicle.setModel("Audi");
		return vehicle;
	}





}
