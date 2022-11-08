package br.com.company.service;

import br.com.company.entity.AddressEntity;
import br.com.company.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<AddressEntity> findAll(){
        return addressRepository.findAll();
    }

    public Optional<AddressEntity> findById(Integer id){
        return addressRepository.findById(id);
    }

    public List<AddressEntity> findAllByClientId(Integer id){
        return addressRepository.findAllByClientId(id);
    }

    public AddressEntity save(AddressEntity address){
        return addressRepository.save(address);
    }

    public Boolean existsById(Integer id){
        return addressRepository.existsById(id);
    }

    public void deleteById(Integer id){
        addressRepository.deleteById(id);
    }

    public AddressEntity checkNullFields(AddressEntity address, AddressEntity newAddress){
        if(newAddress.getAddress()!=null){
            address.setAddress(newAddress.getAddress());
        }
        if(newAddress.getCity()!=null){
            address.setCity(newAddress.getCity());
        }
        if(newAddress.getCnpj()!=null){
            address.setCnpj(newAddress.getCnpj());
        }
        if(newAddress.getComplement()!=null){
            address.setComplement(newAddress.getComplement());
        }
        if(newAddress.getNumber()!=null){
            address.setNumber(newAddress.getNumber());
        }
        if(newAddress.getNeighborhood()!=null){
            address.setNeighborhood(newAddress.getNeighborhood());
        }
        if(newAddress.getState()!=null){
            address.setState(newAddress.getState());
        }
        if(newAddress.getZipCode()!=null){
            address.setZipCode(newAddress.getZipCode());
        }
        return address;
    }

}
