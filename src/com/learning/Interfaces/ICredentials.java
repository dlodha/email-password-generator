package com.learning.Interfaces;

import com.learning.Model.Employee;

public interface ICredentials {
  public String generatePassword();
  public String generateEmailAddress(Employee emp,String department);
  public void showCredential(Employee emp);
}
