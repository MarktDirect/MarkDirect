package com.markdirect.markdirect.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.markdirect.markdirect.beans.DatabaseData;
import com.markdirect.markdirect.beans.ListaDatabaseData;
import com.markdirect.markdirect.database.DatabaseMetricas;

@Controller
public class MetricaController {

	//Creamos el objeto que nos va a servir para conectar con la BBDD
		DatabaseMetricas db = new DatabaseMetricas();
	
	@RequestMapping(value="usersByGender", method=RequestMethod.GET)
	public @ResponseBody ListaDatabaseData usersByGender() {
		ArrayList<DatabaseData> users = db.usersByGender();
		ArrayList<String> cols = new ArrayList<String>();
		ArrayList<String> rows = new ArrayList<String>();
		String row = "{c:[";
		for (int i = 0; i < users.size(); i++) {
			String col = "{id: '" + users.get(i).getDataName() + "', label: '" + users.get(i).getDataName() + "', type: 'number'}";
			cols.add(col);
			row +="{v:" + users.get(i).getDataValue() + "}";
			if(i != users.size() - 1) {
				row += ",";
			}
		}
		row += "]}";
		rows.add(row);
		ListaDatabaseData data = new ListaDatabaseData(cols, rows);
		System.out.println(cols);
		System.out.println(rows);
		return data;
	}
	
	
}
