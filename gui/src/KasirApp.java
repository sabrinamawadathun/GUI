import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KasirApp extends JFrame implements ActionListener { 

    String[] menu = {"Nasi Goreng", "Mie Goreng", "Es Teh"};
    int[] harga = {15000, 13000, 5000};
    int subtotal = 0;

    JComboBox<String> cmbMenu = new JComboBox<>(menu);
    JTextField txtJumlah = new JTextField("1");
    JCheckBox chkMember = new JCheckBox("Member (diskon 10%)");
    JButton btnTambah = new JButton("Tambah");
    JButton btnReset = new JButton("Reset");
    JTextArea areaStruk = new JTextArea();
    JLabel lblTotal = new JLabel("Total: Rp 0");

    public KasirApp() {
        setTitle("Kasir"); 
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));                 

        JPanel panelInput = new JPanel(new GridLayout(4, 2, 5, 5)); 
        panelInput.add(new JLabel("Menu:"));               
        panelInput.add(cmbMenu);                           
        panelInput.add(new JLabel("Jumlah:"));
        panelInput.add(txtJumlah);                         
        panelInput.add(chkMember);                         
        panelInput.add(new JLabel());
        panelInput.add(btnTambah);                         
        panelInput.add(btnReset);

        areaStruk.setEditable(false);
        JPanel panelBawah = new JPanel(new FlowLayout());  
        panelBawah.add(lblTotal);

        add(panelInput, BorderLayout.NORTH);
        add(new JScrollPane(areaStruk), BorderLayout.CENTER); 
        add(panelBawah, BorderLayout.SOUTH);

        // Event Handling
        btnTambah.addActionListener(this);
        btnReset.addActionListener(this);
        chkMember.addItemListener(new ItemListener() {     
            public void itemStateChanged(ItemEvent e) {
                hitungTotal();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTambah) {
            try {
                int jumlah = Integer.parseInt(txtJumlah.getText());
                int i = cmbMenu.getSelectedIndex();
                subtotal += harga[i] * jumlah;
                areaStruk.append(menu[i] + " x" + jumlah + " = Rp " + (harga[i] * jumlah) + "\n");
                hitungTotal();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Jumlah harus angka!");
            }
        } else if (e.getSource() == btnReset) {
            subtotal = 0;
            areaStruk.setText("");
            hitungTotal();
        }
    }

    void hitungTotal() {
        int total = chkMember.isSelected() ? subtotal * 90 / 100 : subtotal;
        lblTotal.setText("Total: Rp " + total);
    }

    public static void main(String[] args) {
        new KasirApp().setVisible(true);
    }
}