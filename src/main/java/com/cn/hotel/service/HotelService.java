package com.cn.hotel.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.cn.hotel.exceptions.HotelNotFoundException;
import com.cn.hotel.model.Hotel;

@Service
public class HotelService {
	
	List<Hotel> hotelList=new ArrayList<>();
	Map<String,Hotel> hotelMap=new HashMap<>();
	
	

	public void createHotel(Hotel hotel) {
		
		hotelList.add(hotel);
		hotelMap.put(hotel.getId(),hotel);
		
	}



	public Hotel getHotelById(String id) {
		if(ObjectUtils.isEmpty(hotelMap.get(id))) {
			throw new HotelNotFoundException("Hotel not found for id: "+id);
		}
		return hotelMap.get(id);
	}



	public List<Hotel> getAllHotels() {
		
		return hotelList;
	}



	public void deleteHotelById(String id) {
		Hotel hotel=getHotelById(id);
		hotelList.remove(hotel);
		hotelMap.remove(id);
		
	}



	public void updateHotel(Hotel updatedHotel) {
		//1.Get the previous data of the hotel
		//2.remove this old data from the list 
		//3. add the updated data to the list
		Hotel existingHotel=getHotelById(updatedHotel.getId());
		hotelList.remove(existingHotel);
		hotelList.add(updatedHotel);
		
		//4.update the previous data with new data
		//5.update the map with new data
		hotelMap.put(updatedHotel.getId(), updatedHotel);
	}

}
