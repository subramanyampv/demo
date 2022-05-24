package com.demo.validators;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.model.Accreditation;
import com.demo.model.Document;

public class AccreditationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Accreditation.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {

		Accreditation request = (Accreditation) target;

		if (StringUtils.isBlank(request.getUserId())) {
			errors.reject("","user_id cannot be null/blank");
		}

		if (Objects.isNull(request.getPayload())) {
			errors.reject("","payload cannot be null");
		}
		if (StringUtils.isBlank(request.getPayload().getAccreditationType())) {
			errors.reject("","accreditation_Type cannot be null/blank");
		}

		if (Objects.isNull(request.getPayload().getDocuments())) {
			errors.reject("","documents cannot be null");
		}

		for (Document document : request.getPayload().getDocuments()) {
			int index = request.getPayload().getDocuments().indexOf(document);
			if (StringUtils.isBlank(document.getName())) {
				errors.reject("","document[" + index + "] name cannot be null/blank");
			}
			if (StringUtils.isBlank(document.getMimeType())) {
				errors.reject("","document[" + index + " ] mime_type cannot be null/blank");
			}
			if (StringUtils.isBlank(document.getContent())) {
				errors.reject("","document[" + index + " ] content cannot be null/blank");
			}
		}
	}

}
