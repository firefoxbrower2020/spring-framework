package com.kittycoder.customtypeconverter.conversion;

import com.kittycoder.customtypeconverter.po.StudentService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * Created by shucheng on 2019-7-13 下午 23:34
 */
public class StudentConversionService implements Converter<String, StudentService> {
	@Override
	public StudentService convert(String source) {
		if (StringUtils.hasLength(source)) {
			String[] sources = source.split("#");

			StudentService studentService = new StudentService();
			studentService.setAge(Integer.parseInt(sources[0]));
			studentService.setName(sources[1]);
			return studentService;
		}
		return null;
	}
}
