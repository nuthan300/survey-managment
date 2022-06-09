package com.ty.survey.services;

import java.util.List;

import com.ty.survey.dao.OptionDao;
import com.ty.survey.dto.Options;

public class OptionService {

	OptionDao dao = new OptionDao();

	public boolean saveOption(int id, Options option) {
		return dao.saveOption(id, option);
	}

	public boolean updateOption(Options option) {
		return dao.updateOption(option);
	}

	public boolean deleteOption(int id) {
		return dao.deleteOption(id);
	}

	public Options getOptionById(int id) {
		return dao.getOptionById(id);
	}

	public List<Options> getAllOption() {
		return dao.getAllOption();
	}
}
