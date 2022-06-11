package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AssociationRepo;
import com.example.demo.Repository.TransacRepo;
import com.example.demo.model.Association;
import com.example.demo.model.DlmsTransaction;
import com.example.demo.model.OperationType;
import com.example.demo.model.OperationTypes;

@Service
public class TransactionService {
	@Autowired
	private TransacRepo dlmstransactionRepo;
	@Autowired
	private AssociationService associationRepo;
	@Autowired
	private ProfilService profilService;
	//CRUD :save:Create , find/findAll :read , Update:update , delete : delete 
	public DlmsTransaction save(DlmsTransaction p)
	{
		return dlmstransactionRepo.save(p);
	}
	public Optional<DlmsTransaction> find(DlmsTransaction p)
	{
		return dlmstransactionRepo.findById(p.getId());
	}
	public Optional<DlmsTransaction> findById(int p)
	{
		return dlmstransactionRepo.findById(p);
	}
	public List<DlmsTransaction> findAll()
	{
		return dlmstransactionRepo.findAll();
	}
	public DlmsTransaction Update(DlmsTransaction p)
	{
		if(p.getId()==find(p).get().getId())
		{
			dlmstransactionRepo.delete(p);
			return dlmstransactionRepo.save(p);
		}
		else {
			return dlmstransactionRepo.save(p);
		}
	}
	public DlmsTransaction delete(DlmsTransaction p)
	{
		dlmstransactionRepo.delete(p);
		 return p;
	}
	//copier une transaction
	public DlmsTransaction CopieDlmsTransaction(DlmsTransaction dlTransaction)
	{
		DlmsTransaction transactionCopie=new DlmsTransaction();
		transactionCopie.setAssociation(dlTransaction.getAssociation());
		transactionCopie.setDlms(dlTransaction.getDlms());
		transactionCopie.setId(dlTransaction.getId());
		transactionCopie.setOperation(dlTransaction.getOperation());
		transactionCopie.setOrdre(dlTransaction.getOrdre());
		transactionCopie.setStop_on_failure(dlTransaction.isStop_on_failure());
		return transactionCopie;
	}
	//Changer l'ordre d'une transaction
	public DlmsTransaction ReoderDlmsTransaction(int id,int order)
	{
		DlmsTransaction transaction= dlmstransactionRepo.findById(id).get();
		transaction.setOrdre(order);
		return transaction;
	}
	//Creer DlmsTransaction
	public DlmsTransaction CreationDlmsTransaction(OperationTypes operationType,Association association,int ordre,String nameProfil,String nameData,String category)
	{
		DlmsTransaction transaction=new DlmsTransaction();
		transaction.setOperation(operationType);
		transaction.setAssociation(association);
		transaction.setOrdre(ordre);
		transaction.setProfil(profilService.CreerProfil(nameProfil, nameData,category));
		return transaction; 
	}
	
}
