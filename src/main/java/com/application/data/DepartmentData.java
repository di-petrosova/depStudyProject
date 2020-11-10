package com.application.data;

public class DepartmentData
{
    private int depId;

    private String depName;
    private String depCity;
    private String depBuilding;
    private String depStreet;
    private String depIndex;

    public int getDepId()
    {
        return depId;
    }

    public void setDepId(int depId)
    {
        this.depId = depId;
    }

    public String getDepName()
    {
        return depName;
    }

    public void setDepName(String depName)
    {
        this.depName = depName;
    }

    public String getDepCity()
    {
        return depCity;
    }

    public void setDepCity(String depCity)
    {
        this.depCity = depCity;
    }

    public String getDepBuilding()
    {
        return depBuilding;
    }

    public void setDepBuilding(String depBuilding)
    {
        this.depBuilding = depBuilding;
    }

    public String getDepStreet()
    {
        return depStreet;
    }

    public void setDepStreet(String depStreet)
    {
        this.depStreet = depStreet;
    }

    public String getDepIndex()
    {
        return depIndex;
    }

    public void setDepIndex(String depIndex)
    {
        this.depIndex = depIndex;
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj instanceof DepartmentData && this.depId == ((DepartmentData)obj).getDepId());
    }
}
