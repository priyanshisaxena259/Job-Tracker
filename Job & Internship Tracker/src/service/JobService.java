package service;

import exception.JobNotFoundException;
import model.Job;
import model.enums.JobType;
import util.FileManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JobService {

    private final FileManager fileManager;
    private final String FILE_NAME = "jobs.txt";

    private ArrayList<Job> jobs;

    // Constructor
    public JobService() {

        fileManager = new FileManager();
        jobs = new ArrayList<>();

        loadJobs();
    }

    // =========================
    // ADD JOB
    // =========================

    public void addJob(Job job) {

        jobs.add(job);

        saveJobs();

        System.out.println("Job added successfully!");
    }

    // =========================
    // VIEW ALL JOBS
    // =========================

    public void viewAllJobs() {

        if (jobs.isEmpty()) {

            System.out.println("No jobs available.");

            return;
        }

        System.out.println("\n========== ALL JOBS ==========");

        for (Job job : jobs) {

            System.out.println(job);
        }
    }

    // =========================
    // FIND JOB BY ID
    // =========================

    public Job getJobById(int id)
            throws JobNotFoundException {

        for (Job job : jobs) {

            if (job.getJobId() == id) {

                return job;
            }
        }

        throw new JobNotFoundException(
                "Job with ID " + id + " was not found."
        );
    }

    // =========================
    // SEARCH JOB
    // =========================

    public void searchJobs(String keyword) {

        boolean found = false;

        System.out.println("\n========== SEARCH RESULTS ==========");

        for (Job job : jobs) {

            if (
                job.getTitle()
                        .toLowerCase()
                        .contains(keyword.toLowerCase())

                ||

                job.getLocation()
                        .toLowerCase()
                        .contains(keyword.toLowerCase())
            ) {

                System.out.println(job);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No jobs found for: " + keyword
            );
        }
    }

    // =========================
    // UPDATE JOB
    // =========================

    public void updateJob(Job updatedJob)
            throws JobNotFoundException {

        for (int i = 0; i < jobs.size(); i++) {

            if (
                jobs.get(i).getJobId()
                        == updatedJob.getJobId()
            ) {

                jobs.set(i, updatedJob);

                saveJobs();

                System.out.println(
                        "Job updated successfully!"
                );

                return;
            }
        }

        throw new JobNotFoundException(
                "Job with ID "
                        + updatedJob.getJobId()
                        + " was not found."
        );
    }

    // =========================
    // DELETE JOB
    // =========================

    public void deleteJob(int id)
            throws JobNotFoundException {

        Job job = getJobById(id);

        jobs.remove(job);

        saveJobs();

        System.out.println(
                "Job deleted successfully!"
        );
    }

    // =========================
    // SAVE JOBS TO FILE
    // =========================

    private void saveJobs() {

        StringBuilder data = new StringBuilder();

        for (Job job : jobs) {

            data.append(job.getJobId()).append("|");
            data.append(job.getRecruiterId()).append("|");
            data.append(job.getTitle()).append("|");
            data.append(job.getDescription()).append("|");
            data.append(job.getLocation()).append("|");
            data.append(job.getSalary()).append("|");
            data.append(job.getJobType()).append("|");
            data.append(job.getDeadline()).append("\n");
        }

        fileManager.saveData(
                FILE_NAME,
                data.toString()
        );
    }

    // =========================
    // LOAD JOBS FROM FILE
    // =========================

    private void loadJobs() {

        List<String> lines =
                fileManager.readData(FILE_NAME);

        for (String line : lines) {

            try {

                String[] parts = line.split("\\|");

                if (parts.length != 8) {
                    continue;
                }

                int jobId =
                        Integer.parseInt(parts[0]);

                int recruiterId =
                        Integer.parseInt(parts[1]);

                String title =
                        parts[2];

                String description =
                        parts[3];

                String location =
                        parts[4];

                double salary =
                        Double.parseDouble(parts[5]);

                JobType jobType =
                        JobType.valueOf(parts[6]);

                LocalDate deadline =
                        LocalDate.parse(parts[7]);

                Job job = new Job(
                        jobId,
                        recruiterId,
                        title,
                        description,
                        location,
                        salary,
                        jobType,
                        deadline
                );

                jobs.add(job);

            } catch (Exception e) {

                System.out.println(
                        "Could not load a job from file."
                );
            }
        }
    }

    // =========================
    // GET JOB LIST
    // =========================

    public ArrayList<Job> getJobs() {

        return jobs;
    }
}