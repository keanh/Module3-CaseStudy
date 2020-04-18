package service;

import model.SmartPhone;

import java.util.List;

public interface SmartPhoneService {
    public List<SmartPhone> findAllSmartPhone();
    public void insertSmartPhone(SmartPhone smartPhone);
    public boolean deleteSmartPhone(int id);
    public boolean updateSmartPhone(SmartPhone smartPhone);
    public SmartPhone selectSmartPhone(int id);
    public SmartPhone selectSmartPhoneByName(String name);
}
