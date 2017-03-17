/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sourcegetter;



import java.awt.*;  
import java.awt.event.*;  
import java.io.InputStream;  
import java.net.*;  
import javax.swing.*;


public class SourceGetter extends JFrame implements ActionListener
{  
    
    JTextField tf;  
    JTextArea ta;  
    JButton b;  
    JLabel l;
    JMenuBar mb;
    JMenu file,options,help;
    JMenuItem save,cut,copy,paste,saveas,selectAll,color,exit,font,about;
    
   
    SourceGetter(){  
        super("Source Code Generator");  
        l=new JLabel("Enter Website URL:");  
        l.setBounds(50,50,250,20);
        
        save=new JMenuItem("save");
        saveas=new JMenuItem("saveas");
        cut=new JMenuItem("cut");
        copy=new JMenuItem("copy");
        paste=new JMenuItem("paste");
        color=new JMenuItem("color");
        exit=new JMenuItem("exit");
        about=new JMenuItem("about");
        selectAll=new JMenuItem("selectAll");
        font=new JMenuItem("font");
        
        font.addActionListener(this);
        saveas.addActionListener(this);
        save.addActionListener(this);
        cut.addActionListener(this);
        paste.addActionListener(this);
        copy.addActionListener(this);
        selectAll.addActionListener(this);
        color.addActionListener(this);
        exit.addActionListener(this);
        about.addActionListener(this);
        
        
        mb=new JMenuBar();
        mb.setBounds(5,5,500,40);
        file=new JMenu("File");
        options=new JMenu("Options");
        help=new JMenu("Help");
        
        file.add(save);
        file.add(saveas);
        file.add(copy);
        file.add(paste);
        file.add(cut);
        file.add(selectAll);
        
        
        options.add(color);
        options.add(font);
        options.add(exit);
        
        help.add(about);
        
        mb.add(file);
        mb.add(options);
        mb.add(help);
        
        tf=new JTextField("Enter the URL here...");  
        tf.setBounds(50,100,250,20);  
        tf.addFocusListener(new FocusListener()
         {
             public void focusGained(FocusEvent e)
             {
              tf.setText("");
             }
         public void focusLost(FocusEvent e)
         {
         }
         });    

        
        b=new JButton("Get Source Code");  
        b.setBounds(50, 150,180,30);  
        b.addActionListener(this);  
          
        ta=new JTextArea();  
        JScrollPane sp=new JScrollPane(ta);
        sp.setBounds(50,200,350,250);  
          
        add(mb);
        add(l);
        add(tf);
        add(b);
        add(sp);
        setSize(500,500);  
        setLayout(null);  
        setVisible(true);  
    }  
    public void actionPerformed(ActionEvent e)
    {  
        String s=tf.getText();  
        if(s==null)
        {}  
        else{  
            try{  
            URL u=new URL(s);  
            URLConnection uc=u.openConnection();  
          
            InputStream is=uc.getInputStream();  
            int i;  
            StringBuilder sb=new StringBuilder();  
            while((i=is.read())!=-1){ 
                sb.append((char)i);  
            }  
            String source=sb.toString(); 
            ta.setText(source);
        if(e.getSource()==cut)
        
            ta.cut();
        
        if(e.getSource()==copy)
         
            ta.copy();
        
        if(e.getSource()==paste)
        
            ta.paste();
        
        if(e.getSource()==selectAll)
        
            ta.selectAll();
        
        if(e.getSource()==exit)
          
            System.exit(0);
           
         }
            
            catch(Exception ex)
            {
             JOptionPane.showMessageDialog(this,"Invalid URL");
            }  
        }  
    }  
    
    public static void main(String[] args) 
    {  
        new SourceGetter();  
    }  
}  
