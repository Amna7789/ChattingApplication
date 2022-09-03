package com.example.chattingapp.shared;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class GenericModelMapper {
    static ModelMapper modelMapper;
    public static Object map(Object source, Object destination){
        if(modelMapper == null){
            modelMapper = new ModelMapper();
        }
        modelMapper.map(source,destination);
        return destination;
    }
    public static <T> T map(Object source, Class<T> destination){
        if(modelMapper == null){
            modelMapper = new ModelMapper();
        }
        return modelMapper.map(source,destination);
        //Object converted
        //return (T) converted;

    }

}
