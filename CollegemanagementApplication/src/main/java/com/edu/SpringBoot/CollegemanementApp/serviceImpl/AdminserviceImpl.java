package com.edu.SpringBoot.CollegemanementApp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBoot.CollegemanementApp.Exception.ResourceNotFound;
import com.edu.SpringBoot.CollegemanementApp.entity.Admin;
import com.edu.SpringBoot.CollegemanementApp.repository.AdminRepository;
import com.edu.SpringBoot.CollegemanementApp.service.AdminService;

public class AdminserviceImpl {
	@Service
	public class AdminServiceImpl implements AdminService {

		private AdminRepository adminRepository;
		
		public AdminServiceImpl(AdminRepository adminRepository) {
			super();
			this.adminRepository = adminRepository;
		}

	    @Override
		public Admin saveAdmin(Admin admin) {
			return adminRepository.save(admin);
		}
	    
	    @Override
		public List<Admin> getAllAdmin() {
			return adminRepository.findAll();
		}

	    @Override
		public Admin getAdminById(long id) {
			Optional<Admin> admin = adminRepository.findById(id);
			if(admin.isPresent()) {
				return admin.get();
			}
			else {
	          throw new ResourceNotFound("Admin","Id",id);
			}
		}

	    @Override
		public Admin updateAdmin(Admin admin, long id) {
			Admin admm = new Admin();
		 try {
			   admm = adminRepository.findById(id).orElseThrow(()->new ResourceNotFound("Admin","Id",id));
		} catch (ResourceNotFound e) {
			
			e.printStackTrace();
		}
		 admm.setFirstName(admm.getFirstName());
		 admm.setLastName(admm.getLastName());
		 admm.setEmail(admm.getEmail());
		 admm.setMobile_no(admm.getMobile_no());
		 
		 adminRepository.save(admm);
		 return admm;
		}
	    
	    @Override
		public List<Admin> getAdminByFirstName(String firstName) {
			return adminRepository.findByFirstName(firstName);
		}

	    @Override
		public List<Admin> getAdminByLastName(String lastName) {
			return adminRepository.findByLastName(lastName);
		}

	    @Override
		public List<Admin> getAdminByFirstNameAndLastName(String firstName, String lastName) {
			return adminRepository.findByFirstNameAndLastName(firstName, lastName);
		}
	    
	    @Override
		public List<Admin> getAdminByFirstNameOrLastName(String firstName, String lastName) {
			return adminRepository.findByFirstNameOrLastName(firstName, lastName);
		}
	    
	    @Override
		public Admin getAdminById(Long id) {
			return adminRepository.findAdminById(id);
		}

	    @Override
		public Admin getAdminFullNameById(long id) {
			return adminRepository.findAdminFullNameById(id);
	    }
	    
	    @Override
		public List<Admin> getAdminInDescOrder() {
			return adminRepository.findAdminInDescOrder();
		}

	    @Override
		public void deleteAdmin(long id) {
			adminRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Admin", "Id", id));
			adminRepository.deleteById(id);
	    }
	}
}

		/*@Override
		public Admin saveAdmin(Admin admin) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Admin> getAllAdmin() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Admin getAdminById(long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Admin> getAdminByFirstName(String firstName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Admin> getAdminByLastName(String lastName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Admin> getAdminByFirstNameOrLastName(String firstName, String lastName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Admin> getAdminByFirstNameAndLastName(String firstName, String lastName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Admin getAdminFullNameById(long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Admin> getAdminInDescOrder() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Admin updateAdmin(Admin admin, long id) {
			// TODO Auto-generated method stub
			return null;
		}
	}*/



