package de.netzmuffel.update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class App {
	private static View form;

	public static void main(String[] args) {
		showAndBlockWaitScreen();
		
		try {
			URL xml = new URL(Config.UPDATE);
			URL download = new URL(Config.DOWNLOAD);

			downloadFile(download, "./");
			downloadFile(xml, "./cfg/");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		enableWaitScreen();
	}

	private static void enableWaitScreen() {
		form.btnNewButton.setText("Click here to start GradeBank.");
		form.btnNewButton.setEnabled(true);
		form.lblNewLabel.setText("Update is done.");
		form.progressBar.setIndeterminate(false);
		
		form.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGradeBank();
			}
		});
	}

	private static void showAndBlockWaitScreen() {
		form = new View();
		form.btnNewButton.setEnabled(false);
	}

	private static void startGradeBank() {
		System.out.println("Starts GradeBank.jar");
		Runtime rt = Runtime.getRuntime();

		try {
			rt.exec("java -jar GradeBank.jar", null, new File("./"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	public static void downloadFile(URL fileURL, String saveDir) throws IOException {
		System.out.println("Start download, Downloadfile: " + fileURL.getFile());
		
		// Code to download
		InputStream in = new BufferedInputStream(fileURL.openStream());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int n = 0;
		while (-1 != (n = in.read(buf))) {
			out.write(buf, 0, n);
		}
		out.close();
		in.close();
		byte[] response = out.toByteArray();

		String fileName = fileURL.getPath();
		fileName = fileName.substring(fileName.lastIndexOf('/') + 1);

		File f = new File(saveDir);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		FileOutputStream fos = new FileOutputStream(saveDir + fileName);
		fos.write(response);
		fos.close();
		// End download code
		System.out.println("Done");
	}
}
