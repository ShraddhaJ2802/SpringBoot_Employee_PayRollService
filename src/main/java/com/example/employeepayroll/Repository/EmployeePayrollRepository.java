package com.example.employeepayroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeepayroll.model.Employee;

// which is used to indicate that the class provides the mechanism for
//storage, retrieval, update, delete and search operation on objects.
//EmployeePayrollRepository extends JpaRepository.
// It contains the full API of CrudRepository and PagingAndSortingRepository. 
//So it contains API for basic CRUD operations and also API for pagination and sorting.

@Repository
public interface EmployeePayrollRepository extends JpaRepository<Employee,Integer> {

}
