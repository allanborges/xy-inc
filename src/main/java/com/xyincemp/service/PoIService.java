package com.xyincemp.service;

import java.util.List;

import com.xyincemp.models.dto.PoIDto;
import com.xyincemp.repository.PoIs;

public class PoIService {

	private PoIs poIs = new PoIs();
	
	public void salva(PoIDto poIDto){
		poIs.salva(poIDto);
	}
	
	public List<PoIDto> listar(){
		return poIs.listar();
	}
	
	public List<PoIDto> listarPorProximidade(PoIDto poiDto){
		return poIs.listarPorProximidade(poiDto);
	}

}
