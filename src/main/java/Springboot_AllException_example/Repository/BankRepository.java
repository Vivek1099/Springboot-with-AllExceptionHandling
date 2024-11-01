package Springboot_AllException_example.Repository;

import Springboot_AllException_example.Entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BankRepository extends JpaRepository<Bank,Integer>
{
    List<Bank> findByaccno(String accno);

    @Query("from bankdetails b where b.fname=?1 and b.lname=?2")
    List<Bank> getByfnameAndlame(String fname, String lname);
}
