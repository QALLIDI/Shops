package com.qallidi.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qallidi.backend.entities.Shop;
import com.qallidi.backend.entities.User;
import com.qallidi.backend.repository.ShopRepository;
import com.qallidi.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(name = "/shops")
public class ShopController {
	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private UserRepository userRepository;

	/* display the list of nearBy Shops Orderd by Distance */
	@RequestMapping(name = "/nearBy", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Shop> findAllOrdredByDistance() {
		List<Shop> nearByShops = new ArrayList<>();
		nearByShops = shopRepository.findAllByOrderByDistanceDesc();
		if (nearByShops.isEmpty()) {
			return null;
		} else {
			return nearByShops;
		}
	}

	/* display the list of preferred Shops Orderd by Distance */
	@RequestMapping(name = "/preferred", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Shop> findAllPreferred(@PathVariable("idUser") Long idUser) {
		List<Shop> nearByShops = new ArrayList<>();
		Optional<User> user = userRepository.findById(idUser);
		nearByShops = user.get().getPreferredShops().stream().sorted((s1, s2) -> {
			return s1.compareByDistance(s2);
		}).collect(Collectors.toList());
		if (nearByShops.isEmpty()) {
			return null;
		} else {
			return nearByShops;
		}
	}

	/* like and add shop to the list of preferred Shops */
	@RequestMapping(name = "/like/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Shop> getBook(@PathVariable("idShop") Long idShop, @PathVariable("idUser") Long idUser) {
		Optional<User> user = userRepository.findById(idUser);
		Optional<Shop> shop = shopRepository.findById(idShop);
		if (user.isPresent()) {
			user.get().addToPreferredShop(shop.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
