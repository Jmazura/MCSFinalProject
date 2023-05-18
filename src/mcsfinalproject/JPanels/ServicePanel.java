package mcsfinalproject.JPanels;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mcsfinalproject.Entities.Amenities;
import mcsfinalproject.Tools.AmenitiesTool;

public class ServicePanel extends JPanel implements ActionListener{
    
    public AmenitiesTool ameTool = new AmenitiesTool("src/mcsfinalproject/datas/amenities.json");
    Amenities aminities = ameTool.getAmenities();
    
    
    private double Tourist_Class;
    private JLabel Tourist_Class_PRICE;
    private double Deluxe_Class;
    private JLabel Deluxe_Class_PRICE;
    private double Ambassador_Class;
    private JLabel Ambassador_Class_PRICE;
    private double Corporate_Class;
    private JLabel Corporate_Class_PRICE;
    
    private double Tourist_Class_Promo ;
    private JLabel Tourist_Class_Promo_PRICE;
    private double Deluxe_Class_Promo;
    private JLabel Deluxe_Class_Promo_PRICE;
    private double Ambassador_Class_Promo;
    private JLabel ambassador_PRICE;
    private double Corporate_Class_Promo;
    private JLabel corporate_PRICE;
    
    private double Extra_Bed;
    private JLabel Extra_Bed_PRICE;
    private double Pillow;
    private JLabel Pillow_PRICE;
    private double Reading_Light;
    private JLabel Reading_Light_PRICE;
    private double Books_And_Magazine;
    private JLabel Books_And_Magazine_PRICE;
    private double Toiletries;
    private JLabel Toiletries_PRICE;
    private double Luggage_Rack;
    private JLabel Luggage_Rack_PRICE;
    
    private double BreakFast;
    private JLabel BreakFast_PRICE;
    private double Lunch;
    private JLabel Lunch_PRICE;
    private double Dinner;
    private JLabel Dinner_PRICE;
    private double Drink;
    private JLabel Drink_PRICE;
    private double Snack;
    private JLabel Snack_PRICE;
    
    private Font myFont = new Font("Courier", Font.BOLD, 32);
    private Font myFont1 = new Font("Courier", Font.BOLD, 16);
    private Font myFont2 = new Font("Courier", Font.BOLD, 14);
    
    private JButton[] buttons = new JButton[15];
            
    
    public ServicePanel()
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        this.getUpdatedAmenities();
        
        JLabel label1 = new JLabel("SERVICE");
        JLabel label2 = new JLabel("REG. RATE PER DAY");
        JLabel label3 = new JLabel("PROMO RATE PER DAY");
        JLabel label4 = new JLabel("ACTIONS");
        
        JLabel Tourist_Classl = new JLabel("Tourist Class");
        JLabel Deluxe_Classl = new JLabel("Deluxe Class");
        JLabel Ambassador_Classl = new JLabel("Ambassador Class");
        JLabel Corporate_Classl = new JLabel("Corporate Class");
        JLabel Tourist_Class_Promol = new JLabel("Tourist Class Promo");
        JLabel Deluxe_Class_Promol = new JLabel("Deluxe Class Promo");
        JLabel Ambassador_Class_Promol = new JLabel("Ambassador Class Promo");
        JLabel Corporate_Class_Promol = new JLabel("Corporate Class Promo");
        JLabel Extra_Bedl = new JLabel("Extra Bed");
        JLabel Pillowl = new JLabel("Pillow");
        JLabel Reading_Lightl = new JLabel("Reading Light");
        JLabel Books_And_Magazinel = new JLabel("Books And Magazine");
        JLabel Toiletriesl = new JLabel("Toiletries");
        JLabel Luggage_Rackl = new JLabel("LuggageRack");
        JLabel BreakFastl = new JLabel("Breakfast");
        JLabel Lunchl = new JLabel("Lunch");
        JLabel Dinnerl = new JLabel("Dinner");
        JLabel Drinkl = new JLabel("Drink");
        JLabel Snackl = new JLabel("Snack");
        
        label1.setFont(myFont2);
        label2.setFont(myFont2);
        label3.setFont(myFont2);
        label4.setFont(myFont2);
        
        //gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 20;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(label1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.add(label2, gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 3;
        gbc.gridy = 0;
        this.add(label3, gbc);
        
        gbc.gridwidth = 1;

        
        for(int i=1; i<=15;i++)
        {
            gbc.gridx = 1;
            gbc.gridy = i;
            switch(i)
            {
                case 1:
                    Tourist_Class_PRICE = new JLabel(Double.toString(this.Tourist_Class));
                    this.add(Tourist_Class_PRICE, gbc);
                    break;
                case 2:
                    Deluxe_Class_PRICE = new JLabel(Double.toString(this.Deluxe_Class));
                    this.add(Deluxe_Class_PRICE, gbc);
                    break;
                case 3:
                    ambassador_PRICE = new JLabel(Double.toString(this.Ambassador_Class));
                    this.add(ambassador_PRICE, gbc);
                    break;
                case 4:
                    corporate_PRICE = new JLabel(Double.toString(this.Corporate_Class));
                    this.add(corporate_PRICE, gbc);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
            }
            
        }
        
        for(int i=1; i<=15;i++)
        {
            JLabel serviceLabel = new JLabel();
            gbc.gridx = 0;
            gbc.gridy= i;
            
            
            if(i == 1)
                serviceLabel.setText("Tourist Class");
            else if(i == 2)
                serviceLabel.setText("Deluxe Class");
            else if(i == 3)
                serviceLabel.setText("Ambassador Class");
            else if(i == 4)
                serviceLabel.setText("Corporate Class");
            else if(i == 5)
                serviceLabel.setText("Extra Bed");
            else if(i == 6)       
                serviceLabel.setText("Pillow");
            else if(i == 7)       
                serviceLabel.setText("Reading Light");
            else if(i == 8)       
                serviceLabel.setText("Books And Magazine");
            else if(i == 9)       
                serviceLabel.setText("Toiletries");
            else if(i == 10)       
                serviceLabel.setText("LuggageRack");
            else if(i == 11)       
                serviceLabel.setText("Breakfast");
            else if(i == 12)       
                serviceLabel.setText("Lunch");
            else if(i == 13)       
                serviceLabel.setText("Dinner");
            else if(i == 14)       
                serviceLabel.setText("Drink");
            else if(i == 15)       
                serviceLabel.setText("Snack");


            this.add(serviceLabel, gbc);
        }
        
        for(int i=0; i<buttons.length;i++)
        {
            gbc.gridx = 2;
            gbc.gridy = 1+i;
            buttons[i] = new JButton("EDIT");
            buttons[i].addActionListener(this);
            this.add(buttons[i], gbc);
        }
        
    }

    
    public double getTourist_Class() {
        return Tourist_Class;
    }

    public void setTourist_Class(double Tourist_Class) {
        this.Tourist_Class = Tourist_Class;
        aminities.setTourist_Class(Tourist_Class);
        ameTool.update(aminities);
    }

    public double getDeluxe_Class() {
        return Deluxe_Class;
    }

    public void setDeluxe_Class(double Deluxe_Class) {
        this.Deluxe_Class = Deluxe_Class;
        aminities.setDeluxe_Class(Deluxe_Class);
        ameTool.update(aminities);
    }

    public double getAmbassador_Class() {
        return Ambassador_Class;
    }

    public void setAmbassador_Class(double Ambassador_Class) {
        this.Ambassador_Class = Ambassador_Class;
        aminities.setAmbassador_Class(Ambassador_Class);
        ameTool.update(aminities);
    }

    public double getCorporate_Class() {
        return Corporate_Class;
    }

    public void setCorporate_Class(double Corporate_Class) {
        this.Corporate_Class = Corporate_Class;
        aminities.setCorporate_Class(Corporate_Class);
        ameTool.update(aminities);
    }

    public double getTourist_Class_Promo() {
        return Tourist_Class_Promo;
    }

    public void setTourist_Class_Promo(double Tourist_Class_Promo) {
        this.Tourist_Class_Promo = Tourist_Class_Promo;
        this.aminities.setTourist_Class_Promo(Tourist_Class_Promo);
        ameTool.update(aminities);
    }

    public double getDeluxe_Class_Promo() {
        return Deluxe_Class_Promo;
    }

    public void setDeluxe_Class_Promo(double Deluxe_Class_Promo) {
        this.Deluxe_Class_Promo = Deluxe_Class_Promo;
        aminities.setDeluxe_Class_Promo(Deluxe_Class_Promo);
        ameTool.update(aminities);
    }

    public double getAmbassador_Class_Promo() {
        return Ambassador_Class_Promo;
    }

    public void setAmbassador_Class_Promo(double Ambassador_Class_Promo) {
        this.Ambassador_Class_Promo = Ambassador_Class_Promo;
        aminities.setAmbassador_Class_Promo(Ambassador_Class_Promo);
        ameTool.update(aminities);
    }

    public double getCorporate_Class_Promo() {
        return Corporate_Class_Promo;
    }

    public void setCorporate_Class_Promo(double Corporate_Class_Promo) {
        this.Corporate_Class_Promo = Corporate_Class_Promo;
        aminities.setCorporate_Class_Promo(Corporate_Class_Promo);
        ameTool.update(aminities);
    }

    public double getExtra_Bed() {
        return Extra_Bed;
    }

    public void setExtra_Bed(double Extra_Bed) {
        this.Extra_Bed = Extra_Bed;
        aminities.setExtra_Bed(Extra_Bed);
        ameTool.update(aminities);
    }

    public double getPillow() {
        return Pillow;
    }

    public void setPillow(double Pillow) {
        this.Pillow = Pillow;
        aminities.setPillow(Pillow);
        ameTool.update(aminities);
    }

    public double getReading_Light() {
        return Reading_Light;
    }

    public void setReading_Light(double Reading_Light) {
        this.Reading_Light = Reading_Light;
        aminities.setReading_Light(Reading_Light);
        ameTool.update(aminities);
    }

    public double getBooks_And_Magazine() {
        return Books_And_Magazine;
    }

    public void setBooks_And_Magazine(double Books_And_Magazine) {
        this.Books_And_Magazine = Books_And_Magazine;
        aminities.setBooks_And_Magazine(Books_And_Magazine);
        ameTool.update(aminities);
    }

    public double getToiletries() {
        return Toiletries;
    }

    public void setToiletries(double Toiletries) {
        this.Toiletries = Toiletries;
        aminities.setToiletries(Toiletries);
        ameTool.update(aminities);
    }

    public double getLuggage_Rack() {
        return Luggage_Rack;
    }

    public void setLuggage_Rack(double Luggage_Rack) {
        this.Luggage_Rack = Luggage_Rack;
        aminities.setLuggage_Rack(Luggage_Rack);
        ameTool.update(aminities);
    }

    public double getBreakFast() {
        return BreakFast;
    }

    public void setBreakFast(double BreakFast) {
        this.BreakFast = BreakFast;
        aminities.setBreakFast(BreakFast);
        ameTool.update(aminities);
    }

    public double getLunch() {
        return Lunch;
    }

    public void setLunch(double Lunch) {
        this.Lunch = Lunch;
        aminities.setLunch(Lunch);
        ameTool.update(aminities);
    }

    public double getDinner() {
        return Dinner;
    }

    public void setDinner(double Dinner) {
        this.Dinner = Dinner;
        aminities.setDinner(Dinner);
        ameTool.update(aminities);
    }

    public double getDrink() {
        return Drink;
    }

    public void setDrink(double Drink) {
        this.Drink = Drink;
        aminities.setDrink(Drink);
        ameTool.update(aminities);
    }

    public double getSnack() {
        return Snack;
    }

    public void setSnack(double Snack) {
        this.Snack = Snack;
        aminities.setSnack(Snack);
        ameTool.update(aminities);
    }
    
    // JUST GETTING THE DATABASE
    public void getUpdatedAmenities()
    {
        Tourist_Class = aminities.getTourist_Class();
        Deluxe_Class = aminities.getDeluxe_Class();
        Ambassador_Class = aminities.getAmbassador_Class();
        Corporate_Class = aminities.getCorporate_Class();
        
        Tourist_Class_Promo = aminities.getTourist_Class_Promo();
        Deluxe_Class_Promo = aminities.getDeluxe_Class_Promo();
        Ambassador_Class_Promo = aminities.getAmbassador_Class_Promo();
        Corporate_Class_Promo = aminities.getCorporate_Class_Promo();
        
        Extra_Bed = aminities.getExtra_Bed();
        Pillow = aminities.getPillow();
        Reading_Light = aminities.getReading_Light();
        Books_And_Magazine = aminities.getBooks_And_Magazine();
        Toiletries = aminities.getToiletries();
        Luggage_Rack = aminities.getLuggage_Rack();
        
        BreakFast = aminities.getBreakFast();
        Lunch = aminities.getLunch();
        Dinner = aminities.getDinner();
        Drink = aminities.getDrink();
        Snack = aminities.getSnack();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object event = e.getSource();
        
        for(int i=0;i<buttons.length;i++)
        {
            switch(i)
            {
                case 0:
                    if(event.equals(buttons[i]))
                    {
                        double number;
                        try{
                        number = Double.parseDouble(JOptionPane.showInputDialog("Change Price: "));
                        
                        this.setTourist_Class(number);                        
                        this.Tourist_Class_PRICE.setText(Double.toString(number));
                        }catch(Exception asd)
                        {
                            
                        }
                 
                    }
                    break;
                    
                case 1:
                    if(event.equals(buttons[i]))
                    {
                        System.out.println("SOMETHING");
                    }
                    break;
            }
        }
    }



    
}
