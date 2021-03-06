/*
 * Copyright (C) 2013 by danjian <josepwnz@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jassap.server.ui;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.jassap.server.Uptimer;

public class StatsBar extends JPanel {
	private static final long serialVersionUID = -4568155395088704811L;
	private JLabel status;
	private JLabel users;
	private JLabel uptime;
	private Uptimer uptimer;
	private Thread uptimeThread;

	public StatsBar() {
		super();
		setLayout(new MigLayout("", "[grow,right]", "[]"));
		
		JLabel lblUptime = new JLabel("Uptime");
		lblUptime.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblUptime, "flowx,cell 0 0");
		
		uptime = new JLabel("-");
		add(uptime, "cell 0 0");
		
		JLabel lblUsers = new JLabel("Users");
		add(lblUsers, "cell 0 0");
		
		users = new JLabel("-");
		add(users, "cell 0 0");
		
		JLabel lblStatus = new JLabel("Status");
		add(lblStatus, "cell 0 0");
		
		status = new JLabel("Offline");
		status.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				// Color para online
				if (status.getText().equals("Online")) {
					status.setForeground(Color.GREEN);
					uptimer = new Uptimer();
					uptimeThread = new Thread(new Runnable() {
						@Override
						public void run() {
							while(true) {
								uptime.setText(uptimer.getTimer());
							}
						}
					});
					uptimeThread.start();
					uptimer.start();
				} else {
					// Color para el resto de estados
					status.setForeground(Color.RED);
					if(uptimeThread != null) {
						uptimer.stop();
						uptimeThread.interrupt();
					}
				}
			}
		});
		add(status, "cell 0 0");
	}
	
	public void setStatus(String s) {
		if(s.equals("Online")) {
			status.setText(s);
		} else {
			status.setText("Offline");
		}
	}
	
	public void setUsers(int n) {
		users.setText(Integer.toString(n));
	}
}
