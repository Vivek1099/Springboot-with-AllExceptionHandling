package Springboot_AllException_example.Controller;

import Springboot_AllException_example.Entity.Bank;
import Springboot_AllException_example.Exceptions.AccountNotFoundException;
import Springboot_AllException_example.Exceptions.IdNotFoundException;
import Springboot_AllException_example.Exceptions.NameNotFoundException;
import Springboot_AllException_example.Repository.BankRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class BankController
{
    @Autowired
    BankRepository bankRepository;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/test")
    public String testcase()
    {
        return "Demo test case";
    }

    @PostMapping("/save")
    public String save(@Valid @RequestBody Bank bank)
    {
        bankRepository.save(bank);
        return "Data saved";
    }

    @GetMapping("/all")
    public List<Bank> all()
    {
        return bankRepository.findAll();
    }

    @GetMapping("/byid/{cid}")
    public Optional<Bank> ById(@PathVariable int cid) throws Exception
    {
        Optional<Bank> bankOptional = bankRepository.findById(cid);
        if(bankOptional.isEmpty())
        {
            throw new IdNotFoundException();
        }
        return bankOptional;
    }

    @GetMapping("/byname/{fname}/{lname}")
    public List<Bank> ByName(@PathVariable String fname, @PathVariable String lname) throws Exception
    {
        List<Bank> bankList = bankRepository.getByfnameAndlame(fname, lname);
        if(bankList.isEmpty())
        {
            throw new NameNotFoundException();
        }
        return  bankList;
    }

    @GetMapping("/byaccno/{accno}")
    public List<Bank> ByAccNo(@PathVariable String accno) throws Exception
    {
        List<Bank> bankList = bankRepository.findByaccno(accno);
        if(bankList.isEmpty())
        {
            throw new AccountNotFoundException();
        }
        return bankList;
    }

    @PatchMapping("/update/{cid}")
    public Bank update(@RequestBody Bank bank, @PathVariable int cid)
    {
        Bank b = bankRepository.findById(cid).get();
        b.setFname(bank.getFname());
        b.setLname(bank.getLname());
        b.setAge(bank.getAge());
        b.setAddress(bank.getAddress());
        b.setPhoneno(bank.getPhoneno());
        b.setPincode(bank.getPincode());
        b.setEmail(bank.getEmail());
        modelMapper.map(b,bank);
        return bank;
    }

    @DeleteMapping("/delete/{cid}")
    public String delete(@PathVariable int cid)
    {
        bankRepository.deleteById(cid);
        return "Data deleted";
    }
}
