package com.workmotion.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.workmotion.controller.EmployeeController;
import com.workmotion.model.Employee;
import com.workmotion.model.EmployeeState;
import com.workmotion.utilities.HibernateUtil;

public class EmployeeService{
    
	private final static Logger LOGGER = Logger.getLogger(EmployeeService.class.getName());
	
   /* @Override
    public UserProfileDto saveUser(UserProfileDto userDto) throws UserServiceException {
        
        UserProfileDto returnValue = null;
        
        // Generate salt
        String salt = authenticationUtil.generateSalt(30);
        
        // Generate secure user password 
        String secureUserPassword = null;
        
        try {
            secureUserPassword = authenticationUtil.
                    generateSecurePassword(userDto.getUserPassword(), salt);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new UserServiceException(ex.getLocalizedMessage());
        } 
        
        //Generate secure public user id
        String securePublicUserId = authenticationUtil.generateUserId(30);
        
        userDto.setSalt(salt);
        userDto.setUserPassword(secureUserPassword); 
        userDto.setUserId(securePublicUserId);
                
        UserProfileEntity userEntity = new UserProfileEntity();
        BeanUtils.copyProperties(userDto, userEntity);
     
        // Connect to database 
        try {
            this.database.openConnection();
            UserProfileEntity storedUserEntity = this.database.saveUserProfile(userEntity);
            if(storedUserEntity != null && storedUserEntity.getId()>0)
            {
                returnValue = new UserProfileDto();
                BeanUtils.copyProperties(storedUserEntity, returnValue);
            }
        }  finally {
            this.database.closeConnection();
        }
        
        return returnValue;
    }*/



	public Employee saveEmployee(Employee employee) {
		try{ 
		  SessionFactory sessFact = HibernateUtil.getSessionFactory();
			Session session = sessFact.getCurrentSession();
			org.hibernate.Transaction tr = session.beginTransaction();
			Employee emp = new Employee();
			emp.setName(employee.getName());
			emp.setAge(employee.getAge());
			emp.setContractType(employee.getContractType());
			emp.setState(EmployeeState.ADDED);
			session.save(emp);
			tr.commit();
			LOGGER.info("Employee saved in database " + emp.getName());
			sessFact.close();
		} catch (Exception ex) {
			 LOGGER.log(Level.SEVERE, "Error in saveEmployee - " + ex.getMessage()); 
	    }
		return employee;
	}
}
