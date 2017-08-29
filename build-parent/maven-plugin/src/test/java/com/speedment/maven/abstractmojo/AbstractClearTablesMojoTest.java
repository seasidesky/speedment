package com.speedment.maven.abstractmojo;

import com.speedment.runtime.core.Speedment;
import com.speedment.tool.core.internal.util.ConfigFileHelper;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AbstractClearTablesMojoTest {

	private AbstractClearTablesMojoTestImpl mojo;

	private String mockedConfigLocation = "testFile.txt";
	@Mock
	private Speedment mockedSpeedment;
	@Mock
	private ConfigFileHelper mockedConfigFileHelper;
	@Mock
	private MavenProject mockedMavenProject;


	@Before
	public void setup() {
		when(mockedMavenProject.getBasedir()).thenReturn(new File("baseDir"));

		mojo = new AbstractClearTablesMojoTestImpl() {
			@Override
			protected MavenProject project() {
				return mockedMavenProject;
			}
		};
	}

	@Test
	public void execute() throws Exception {
		// Given
		when(mockedSpeedment.getOrThrow(ConfigFileHelper.class)).thenReturn(mockedConfigFileHelper);
		mojo.setConfigFile(mockedConfigLocation);

		// When
		mojo.execute(mockedSpeedment);

		// Then
		verify(mockedConfigFileHelper).setCurrentlyOpenFile(Paths.get("baseDir", mockedConfigLocation).toFile());
		verify(mockedConfigFileHelper).clearTablesAndSaveToFile();
	}

	@Test(expected = MojoExecutionException.class)
	public void executeException() throws Exception {
		// Given
		when(mockedSpeedment.getOrThrow(ConfigFileHelper.class)).thenReturn(mockedConfigFileHelper);
		doThrow(new RuntimeException("test Exception")).when(mockedConfigFileHelper).clearTablesAndSaveToFile();
		mojo.setConfigFile(mockedConfigLocation);

		// When
		mojo.execute(mockedSpeedment);

		// Then
	}
}