import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class Editor implements ActionListener {
	JFrame fm;
	JMenuBar menu;
	JMenu file, edit, View;
	JMenuItem cut, copy, paste, New, undo, Find, Replace, saveas, newwindow, save, open, Wrap;
	JTextArea area;
	UndoManager undoManager;
	File currentFile;

	public Editor() {
		// TODO Auto-generated constructor stub
		fm = new JFrame();
		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		undo = new JMenuItem("Undo");
		open = new JMenuItem("Open");
		New = new JMenuItem("New");
		Find = new JMenuItem("Find");
		saveas = new JMenuItem("Save as");
		save = new JMenuItem("Save");
		newwindow = new JMenuItem("New window");
		Replace = new JMenuItem("Replace");
		Wrap = new JCheckBoxMenuItem("Word Wrap");

		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		newwindow.addActionListener(this);
		saveas.addActionListener(this);
		open.addActionListener(this);
		New.addActionListener(this);
		save.addActionListener(this);
		undo.addActionListener(this);
		Find.addActionListener(this);
		Replace.addActionListener(this);
		Wrap.addActionListener(this);

		menu = new JMenuBar();
		file = new JMenu("File");
		edit = new JMenu("Edit");
		View = new JMenu("View");

		file.add(New);
		file.add(newwindow);
		file.add(open);
		file.add(saveas);
		file.add(save);

		edit.add(undo);
		edit.add("Cut");
		edit.add("Copy");
		edit.add("Paste");
		edit.add(Find);
		edit.add(Replace);
		View.add(Wrap);

		menu.add(file);
		menu.add(edit);
		menu.add(View);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Madhup\\notepad.jpg");    
	    fm.setIconImage(icon);    

		area = new JTextArea();
		area.setBounds(1, 1, 4000, 4000);

		fm.add(menu);
		fm.add(area);

		fm.setJMenuBar(menu);
		fm.setLayout(null);
		fm.setTitle("Editor");
//		fm.setBackground(Color.black);
//		fm.setForeground(Color.white);
		fm.setSize(500, 500);
		fm.setVisible(true);

		undoManager = new UndoManager();
		area.getDocument().addUndoableEditListener(e -> {
		undoManager.addEdit(e.getEdit());
		area.getDocument().addUndoableEditListener(undoManager);
		});
		Font defaultFont = new Font("Arial", Font.PLAIN, 16);
		area.setFont(defaultFont);
	}

	private void openFile(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuilder content = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}

			reader.close();
			area.setText(content.toString());
		} catch (IOException e) {
		}

		@SuppressWarnings({ "serial", "unused" })
		class invalid extends Exception {
			public invalid(String mssg) {
				// TODO Auto-generated constructor stub
				super(mssg);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == New) {
			new Editor();
		}

		if (e.getSource() == newwindow) {
			new Editor();
		}

		if (e.getSource() == open) {
			FileDialog fdopen = new FileDialog(fm, "Open File", FileDialog.LOAD);
			fdopen.setVisible(true);
			String directory = fdopen.getDirectory();
			String filename = fdopen.getFile();

			if (directory != null && filename != null) {
				try {
					File selectFile = new File(directory, filename);
					openFile(selectFile);
					currentFile = selectFile;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		if (e.getSource() == save) {
			if (currentFile != null) {
				save(currentFile);
			} else {
				// Handle case where no current file is set or saved yet.
			}
		}

		if (e.getSource() == saveas) {
		    try {
		        String txt = area.getText();
		        if (area.getText().length() > 0) {
		            FileDialog fd = new FileDialog(fm, "Save File as", FileDialog.SAVE);
		            fd.setFile("tmp.txt");
		            fd.setDirectory("C:\\Madhup");
		            fd.setVisible(true);
		            String path = fd.getDirectory() + fd.getFile();

		            FileOutputStream file = new FileOutputStream(path);
		            byte[] bytes = txt.getBytes();
		            file.write(bytes);
		            file.close();
		        }
		    } catch (Exception e2) {
		        System.out.println(e2);
		    }
		}


		if (e.getSource() == cut)
			area.cut();
		if (e.getSource() == copy)
			area.copy();
		if (e.getSource() == paste)
			area.paste();
		if (e.getSource() == undo) {
			try {
				if (undoManager.canUndo()) {
					undoManager.undo();
				}
			} catch (CannotUndoException ex) {
			}
		}
		if (e.getSource() == Find) {
			String search = JOptionPane.showInputDialog(fm, "Find: ");
			if (search != null && !search.isEmpty()) {
				String text = area.getText();
				int index = text.indexOf(search);

				if (index != -1) {
					// Text found, highlight it
					area.setCaretPosition(index);
					area.setSelectionStart(index);
					area.setSelectionEnd(index + search.length());
				} else {
					// Text not found, display a message
					JOptionPane.showMessageDialog(fm, "Text not found", "Find", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		if (e.getSource() == Replace) {
			String search = JOptionPane.showInputDialog(fm, "Find:");
			if (search != null && !search.isEmpty()) {
				String replacetxt = JOptionPane.showInputDialog(fm, "Replace:");
				if (replacetxt != null) {
					String text = area.getText();
					int index = text.indexOf(search);

					if (index != -1) {
						// Text found, replace it
						area.replaceRange(replacetxt, index, index + search.length());
					} else {
						// Text not found, display a message
						JOptionPane.showMessageDialog(fm, "Not found", "Replace", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		}
		if (e.getSource() == Wrap) {
			wordWrap();
			View.add(Wrap);
		}
	}

	private void wordWrap() {
		area.setLineWrap(Wrap.isSelected());
		area.setWrapStyleWord(Wrap.isSelected());
	}

	private void save(File file) {
		try {
			String txt = area.getText();

			if (!txt.isEmpty()) {
				String path = file.getAbsolutePath();
				FileOutputStream fileOut = new FileOutputStream(path);
				byte[] bytes = txt.getBytes();
				fileOut.write(bytes);
				fileOut.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Editor();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
		}
	}
}